package com.company.tondeuse.enums;

import lombok.Getter;

public enum Direction {
    NORTH("N"),
    WEST("W"),
    EAST("E"),
    SOUTH("S");

    @Getter
    private String code;


    private Direction(String code) {
        this.code = code;
    }
    public static Direction getDirection(String c){
        for(Direction direction : Direction.values()) {
            if (direction.getCode().equalsIgnoreCase(c)){
                return direction;
            }
        }
        return null;
    }


}
