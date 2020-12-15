package com.mufg.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.mufg.demo.data.BotOperateRequestData;
import com.mufg.demo.data.DirectionEnum;
import com.mufg.demo.data.Movement;
import com.mufg.demo.data.OutputResponse;
import com.mufg.demo.exception.ProvidedPositionIsNotConsidered;

@Service
public class BotOperateServiceImpl implements BotOperateService {

    static final String F = "F";
    static final String B = "B";
    static final String L = "L";
    static final String R = "R";
    static final String FILE_LOCATION = "/src/main/resources/output.xml";

    @Override
    public OutputResponse operate(BotOperateRequestData botOperateRequestData) {
        OutputResponse reponse = null;
        // Validating for empty data
        if (ObjectUtils.isEmpty(botOperateRequestData) || ObjectUtils.isEmpty(botOperateRequestData.getPosition())) {
            throw new ProvidedPositionIsNotConsidered("position can not be empty");
        }

        DirectionEnum currectDirection = DirectionEnum.getDirection(botOperateRequestData.getPosition().getDirection());

        // Throw if other than N,S,E,W
        if (DirectionEnum.I.equals(currectDirection)) { throw new ProvidedPositionIsNotConsidered("position is not proper"); }

        int positionx = botOperateRequestData.getPosition().getX();
        int positiony = botOperateRequestData.getPosition().getY();

        List<Movement> movements = new ArrayList<>();
        for (BotOperateRequestData.Move move : botOperateRequestData.getMove()) {

            String rotationAngle = move.getL() != null ? L : R;
            Integer rotationValue = move.getL() != null ? move.getL() : move.getR();
            String moveDirection = move.getF() != null ? F : B;
            Integer moveValue = move.getF() != null ? move.getF() : move.getB();

            // Sorting according to order
            Movement movement = Movement.getInstance(Integer.valueOf(move.getO()), rotationAngle, rotationValue, moveDirection, moveValue);
            movements.add(movement);
        }

        for (Movement movement : movements) {

            // Assigning new angle after each loop
            currectDirection = DirectionEnum.getDirection(currectDirection, movement.getRotateAngle(), movement.getRotateValue());

            switch (currectDirection) {
                case E:

                    switch (movement.getMoveType()) {
                        case F:
                            positionx = positionx + movement.getMoveValue();
                        break;

                        case B:
                            positionx = positionx - movement.getMoveValue();
                        break;
                    }
                break;
                case W:
                    switch (movement.getMoveType()) {
                        case F:
                            positionx = positionx - movement.getMoveValue();
                        break;

                        case B:
                            positionx = positionx + movement.getMoveValue();
                        break;
                    }
                break;

                case N:
                    switch (movement.getMoveType()) {
                        case F:
                            positiony = positiony + movement.getMoveValue();
                        break;

                        case B:
                            positiony = positiony - movement.getMoveValue();
                        break;
                    }
                break;
                case S:
                    switch (movement.getMoveType()) {
                        case F:
                            positiony = positiony - movement.getMoveValue();
                        break;

                        case B:
                            positiony = positiony + movement.getMoveValue();
                        break;
                    }
                break;
                default:
                break;
            }
        }

        try {

            // writing as xml
            final com.mufg.demo.data.ObjectFactory factory = new com.mufg.demo.data.ObjectFactory();
            reponse = factory.createOutputData();

            final OutputResponse.Position position = factory.createPositionData();
            position.setDirection(currectDirection.name());
            position.setX(positionx);
            position.setY(positiony);
            reponse.setPosition(position);

            // save as xml file in resource folder
            BotFileUtils.writeToFile(reponse, FILE_LOCATION);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return reponse;
    }

    @Override
    public OutputResponse getLocation() {
        return BotFileUtils.readFromFile(FILE_LOCATION);
    }

}
