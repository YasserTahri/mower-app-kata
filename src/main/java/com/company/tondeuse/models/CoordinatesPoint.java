package com.company.tondeuse.models;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class CoordinatesPoint {
    private int x, y;

    public boolean isValidCoordinates(CoordinatesPoint coordinatesPoint){
        return coordinatesPoint.getX() >=0 && coordinatesPoint.getY() >=0 && coordinatesPoint.getX() <= this.x && coordinatesPoint.getY() <= this.y;
    }

}
