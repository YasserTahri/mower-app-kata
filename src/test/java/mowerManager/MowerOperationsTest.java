package mowerManager;

import com.company.tondeuse.enums.Direction;
import com.company.tondeuse.enums.MowerInstruction;
import com.company.tondeuse.exception.MowerException;
import com.company.tondeuse.models.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.io.IOException;
import java.util.List;

public class MowerOperationsTest {


    @Test
    public void shouldTurnOnLeftAndGetDirectionWEST() throws MowerException {
        CoordinatesPoint coordinatesPoint = new CoordinatesPoint(1,2);

        MowerPosition mowerPosition = new MowerPosition(coordinatesPoint, Direction.NORTH);
        MowerOperations.execute(mowerPosition,MowerInstruction.LEFT,coordinatesPoint);

        Assert.assertEquals(mowerPosition.getCoordinates(), new CoordinatesPoint(1,2));
        Assert.assertEquals(mowerPosition.getMowerDirection(), Direction.WEST);
    }
    @Test
    public void shouldTurnOnLeftAndGetDirectionEAST() throws MowerException {
        CoordinatesPoint coordinatesPoint = new CoordinatesPoint(1,2);

        MowerPosition mowerPosition = new MowerPosition(coordinatesPoint, Direction.SOUTH);
        MowerOperations.execute(mowerPosition,MowerInstruction.LEFT,coordinatesPoint);
        Assert.assertEquals(mowerPosition.getCoordinates(), new CoordinatesPoint(1,2));
        Assert.assertEquals(mowerPosition.getMowerDirection(), Direction.EAST);
    }


    @Test
    public void shouldTurnOnRightAndGetDirectionEAST() throws MowerException {
        CoordinatesPoint coordinatesPoint = new CoordinatesPoint(1,2);

        MowerPosition mowerPosition = new MowerPosition(coordinatesPoint, Direction.NORTH);
        MowerOperations.execute(mowerPosition,MowerInstruction.RIGHT,coordinatesPoint);

        Assert.assertEquals(mowerPosition.getCoordinates(), new CoordinatesPoint(1,2));
        Assert.assertEquals(mowerPosition.getMowerDirection(), Direction.EAST);
    }

}
