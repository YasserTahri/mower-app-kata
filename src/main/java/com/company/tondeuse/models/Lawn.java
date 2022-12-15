package com.company.tondeuse.models;

import com.company.tondeuse.interfaces.LawnBehavior;
import lombok.*;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Lawn implements LawnBehavior {

    @Getter
    @Setter
    private Integer width;

    @Getter
    @Setter
    private Integer height;

    @Override
    public boolean isValid(CoordinatesPoint coordinatesPoint) {
        boolean isValidX =  (coordinatesPoint.getX() <= this.getWidth() && coordinatesPoint.getX() >= 0)? true : false;
        boolean isValidY =  (coordinatesPoint.getY() <= this.getHeight() && coordinatesPoint.getY() >= 0) ? true : false;

        return (isValidX && isValidY);
    }
}
