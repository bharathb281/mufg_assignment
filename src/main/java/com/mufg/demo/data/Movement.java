package com.mufg.demo.data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Movement implements Comparable<Movement> {

    private final Integer order;
    private final String rotateAngle;
    private final Integer rotateValue;
    private final String moveType;
    private final Integer moveValue;

    private Movement(final Integer order, final String rotateAngle, final Integer rotateValue, final String moveType,
            final Integer moveValue) {
        this.order = order;
        this.rotateAngle = rotateAngle;
        this.rotateValue = rotateValue;
        this.moveType = moveType;
        this.moveValue = moveValue;
    }

    public static Movement getInstance(final Integer order, final String rotateAngle, final Integer rotateValue, final String moveType,
            final Integer moveValue) {
        return new Movement(order, rotateAngle, rotateValue, moveType, moveValue);
    }

    @Override
    public int compareTo(Movement o) {
        if (this.order > o.order) {
            return 1;
        } else if (this.order < o.order) { return -1; }
        return 0;
    }
}
