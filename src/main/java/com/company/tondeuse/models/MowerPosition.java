package com.company.tondeuse.models;

import com.company.tondeuse.enums.Direction;
import lombok.*;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class MowerPosition {

    @Getter
    @Setter
    private CoordinatesPoint coordinates;

    @Getter
    @Setter
    private Direction mowerDirection;
}
