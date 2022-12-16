package com.company.tondeuse.models;

import com.company.tondeuse.enums.Direction;
import com.company.tondeuse.enums.MowerInstruction;
import com.company.tondeuse.exception.MowerException;
import com.company.tondeuse.utils.Parser;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@EqualsAndHashCode
public class Mower{

    @Getter
    @Setter
    private CoordinatesPoint coordinatesPoint;

    @Getter
    @Setter
    private Direction direction;

    @Getter
    @Setter
    private Lawn lawn;

    @Getter
    @Setter
    private MowerPosition mowerPosition;

    public Mower(CoordinatesPoint coordinatesPoint, Direction direction, Lawn lawn) {
        this.coordinatesPoint = coordinatesPoint;
        this.direction = direction;
        this.lawn = lawn;
    }
    public Mower(MowerPosition mowerPosition,CoordinatesPoint coordinatesPoint) {
        this.mowerPosition = mowerPosition;
        this.coordinatesPoint = coordinatesPoint;
    }

    public Mower() {

    }
    public MowerPosition simulateMower(MowerPosition position, String instructions) throws MowerException {
        List<MowerInstruction> listInstructions = Parser.parseInstructions(instructions);
        MowerPosition finalMowerPosition = null;
        for(MowerInstruction mowerInstruction : listInstructions){
            finalMowerPosition = MowerOperations.execute(position, mowerInstruction, coordinatesPoint);
        }
        return finalMowerPosition;
    }

    public String toString(){
        return 	mowerPosition.getCoordinates().getX()
                + " "
                + mowerPosition.getCoordinates().getY()
                + " "
                + mowerPosition.getMowerDirection().getCode() ;
    }
}
