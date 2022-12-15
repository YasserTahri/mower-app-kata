package com.company.tondeuse.utils;

import com.company.tondeuse.enums.Direction;
import com.company.tondeuse.enums.MowerInstruction;
import com.company.tondeuse.models.CoordinatesPoint;
import com.company.tondeuse.models.Lawn;
import com.company.tondeuse.models.Mower;
import com.company.tondeuse.tranverse.Constants;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    public static Lawn parseLawn(String data){
        if(data.matches(Constants.sourcePattern)){
            String[] elements = data.split(Constants.SEPARTOR);
            return new Lawn(Integer.parseInt(elements[0]),Integer.parseInt(elements[1]));
        }
        return null;
    }

    public static Mower parseMower(String data, Lawn lawn){
        if(data.matches(Constants.SOURCE_PATTERN_MOWER)){
            String[] dataSplited = doSplit(data);
            int a = Integer.parseInt(dataSplited[0]);
            int b = Integer.parseInt(dataSplited[1]);
            Direction d = Direction.getDirection(dataSplited[2]);
            return new Mower(new CoordinatesPoint(a,b),d, lawn);
        }
        return null;
    }
    public static List<MowerInstruction> parseInstructions(String instructions){

        List<MowerInstruction> instructionsList = new ArrayList<MowerInstruction>();
        String[] tab = instructions.split("");
        for(int i = 0; i < tab.length; i++){
            instructionsList.add(MowerInstruction.getInstruction(tab[i]));
        }
        return instructionsList;
    }


    private static String[] doSplit(String data){
        return data.split(Constants.SEPARTOR);
    }
}
