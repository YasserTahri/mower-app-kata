package com.company.tondeuse.models;

import com.company.tondeuse.enums.Direction;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@EqualsAndHashCode
public class MowerPosition {

    @Getter
    @Setter
    private CoordinatesPoint coordinates;

    @Getter
    @Setter
    private Direction mowerDirection;
}
