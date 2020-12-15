package com.mufg.demo.data;

import org.springframework.util.ObjectUtils;

public enum DirectionEnum {

    I, N, E, S, W;

    public static DirectionEnum getDirection(String direction) {

        DirectionEnum directionEnum = I;
        if (ObjectUtils.isEmpty(direction)) { return directionEnum; }
        switch (direction) {
            case "N":
                directionEnum = N;
            break;
            case "E":
                directionEnum = E;
            break;

            case "S":
                directionEnum = S;
            break;

            case "W":
                directionEnum = W;
            break;
        }
        return directionEnum;
    }

    public static DirectionEnum getDirection(DirectionEnum currectDirection, String rotateAngle, Integer rotateValue) {

        DirectionEnum directionEnum = I;

        switch (currectDirection) {
            case N:

                switch (rotateAngle + String.valueOf(rotateValue)) {
                    case "L90":
                    case "R270":
                        directionEnum = W;
                    break;

                    case "R90":
                    case "L270":
                        directionEnum = E;
                    break;

                    case "L180":
                    case "R180":
                        directionEnum = S;
                    break;

                    default:
                        directionEnum = N;
                    break;
                }
            break;

            case E:

                switch (rotateAngle + String.valueOf(rotateValue)) {
                    case "L90":
                    case "R270":
                        directionEnum = N;
                    break;

                    case "R90":
                    case "L270":
                        directionEnum = S;
                    break;

                    case "L180":
                    case "R180":
                        directionEnum = W;
                    break;

                    default:
                        directionEnum = E;
                    break;
                }
            break;

            case S:

                switch (rotateAngle + String.valueOf(rotateValue)) {
                    case "L90":
                    case "R270":
                        directionEnum = E;
                    break;

                    case "R90":
                    case "L270":
                        directionEnum = W;
                    break;

                    case "L180":
                    case "R180":
                        directionEnum = N;
                    break;

                    default:
                        directionEnum = S;
                    break;
                }
            break;

            case W:

                switch (rotateAngle + String.valueOf(rotateValue)) {
                    case "L90":
                    case "R270":
                        directionEnum = S;
                    break;

                    case "R90":
                    case "L270":
                        directionEnum = N;
                    break;

                    case "L180":
                    case "R180":
                        directionEnum = E;
                    break;

                    default:
                        directionEnum = W;
                    break;
                }
            break;

            default:
            break;
        }

        return directionEnum;
    }

}
