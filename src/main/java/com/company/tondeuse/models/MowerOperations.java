package com.company.tondeuse.models;

import com.company.tondeuse.enums.Direction;
import com.company.tondeuse.enums.MowerInstruction;
import com.company.tondeuse.exception.MowerException;
import com.company.tondeuse.tranverse.Constants;


public class MowerOperations {

    public static CoordinatesPoint proceed(MowerPosition mowerPosition, CoordinatesPoint coordinatesPoint) throws MowerException {
        CoordinatesPoint coordinatesPoint1 = null;

        switch (mowerPosition.getMowerDirection()){
            case NORTH:
                coordinatesPoint1 = new CoordinatesPoint(mowerPosition.getCoordinates().getX(), coordinatesPoint.getY()+1); break;
            case EAST:
                coordinatesPoint1 = new CoordinatesPoint(mowerPosition.getCoordinates().getX()+ 1, mowerPosition.getCoordinates().getY()); break;
            case SOUTH:
                coordinatesPoint1 = new CoordinatesPoint(mowerPosition.getCoordinates().getX(), mowerPosition.getCoordinates().getY()-1); break;
            case WEST:
                coordinatesPoint1 = new CoordinatesPoint(mowerPosition.getCoordinates().getX()-1, mowerPosition.getCoordinates().getY()); break;
            default:
                throw new MowerException(Constants.BAD_POSITION);
        }

        if(coordinatesPoint1 != null && coordinatesPoint1.isValidCoordinates(coordinatesPoint1)){
            return coordinatesPoint1;
        }else{
            return mowerPosition.getCoordinates();
        }
    }
    public static Direction turnOnRight(Direction d) throws MowerException {
        Direction direction = null;
        switch (d){
            case NORTH:
                direction = Direction.EAST; break;
            case EAST:
                direction = Direction.SOUTH; break;
            case SOUTH:
                direction = Direction.WEST; break;
            case WEST:
                direction = Direction.NORTH; break;
            default:
                throw new MowerException(Constants.BAD_DIRECTION);
        }
        return direction;
    }
    public static Direction turnOnLeft(Direction direction) throws MowerException {
        Direction direction1 = null;
        switch (direction){
            case NORTH:
                direction1 = Direction.WEST;
                break;
            case EAST:
                direction1 = Direction.NORTH; break;
            case SOUTH:
                direction1 = Direction.EAST; break;
            case WEST:
                direction1 = Direction.SOUTH; break;
            default:
                throw new MowerException(Constants.BAD_DIRECTION);
        }
        return direction1;
    }

    public static MowerPosition execute(MowerPosition mowerPosition, MowerInstruction mowerInstruction, CoordinatesPoint coordinatesPoint) throws MowerException {

        switch (mowerInstruction){
            case LEFT:
                mowerPosition.setMowerDirection(turnOnLeft(mowerPosition.getMowerDirection()));
                break;
            case RIGHT:
                mowerPosition.setMowerDirection(turnOnRight(mowerPosition.getMowerDirection()));
                break;
            case MOVE:
                mowerPosition.setCoordinates(proceed(mowerPosition, coordinatesPoint));
                break;
            default:
                throw new MowerException(Constants.BAD_DATA);
        }
        return mowerPosition;
    }

}
