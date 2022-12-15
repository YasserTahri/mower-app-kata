package com.company.tondeuse.interfaces;

import com.company.tondeuse.models.CoordinatesPoint;

public interface LawnBehavior {

    boolean isValid(CoordinatesPoint coordinatesPoint);
}
