package com.company.tondeuse.enums;

import lombok.Getter;


public enum MowerInstruction {

    RIGHT("D","turn on right"),
    LEFT("G","turn on left"),
    MOVE("A","move on");

    @Getter
    private String code;
    @Getter
    private String nameInstruction;

    private MowerInstruction(String code, String name) {
        this.code = code;
        this.nameInstruction = name;
    }

    public static MowerInstruction getInstruction(String code) {
       for(MowerInstruction instruction : MowerInstruction.values()){
           if(instruction.getCode().equalsIgnoreCase(code)){
               return instruction;

           }
       }
       return null;
    }
}
