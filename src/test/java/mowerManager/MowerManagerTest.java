package mowerManager;

import com.company.tondeuse.enums.Direction;
import com.company.tondeuse.exception.MowerException;
import com.company.tondeuse.models.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.io.IOException;
import java.util.List;

public class MowerManagerTest {

    MowerManager mowerManager = new MowerManager();

    @Before
    @Test
    public void loadFile() throws IOException {
        mowerManager.extractData();
    }

    @Test
    @DisplayName("do get Lawn")
    public void extractLawnFromFile() throws IOException {
       Lawn lawn = mowerManager.extractLawnFromFile();
       Lawn expectedLawn = new Lawn(5,5);
       Assert.assertEquals(lawn, expectedLawn);
    }
    @Test
    @DisplayName("do get mower instructions")
    public void getAllInstructions() throws IOException {
        List<String> instructions = mowerManager.selectAllInstructions();
        Assert.assertTrue(instructions.size() > 0);
    }
    @Test
    @DisplayName("execute instructions")
    public void executeInstructions() throws IOException, MowerException {
        List<Mower> mowerList = mowerManager.extractAllMowers();
        List<String> instructionsList = mowerManager.selectAllInstructions();
        // CoordinatesPoint mower 0
        CoordinatesPoint coordinatesMower0 = mowerList.get(0).getCoordinatesPoint();
        // Direction mower 0
        Direction directionMower0 = mowerList.get(0).getDirection();
        Assert.assertEquals(directionMower0, Direction.NORTH);
        Assert.assertEquals(coordinatesMower0, new CoordinatesPoint(1,2));

        MowerPosition mowerPosition = new MowerPosition(coordinatesMower0, directionMower0);

        Mower mower0 = mowerList.get(0);
        // execute mower instructions
        mower0.simulateMower(mowerPosition, instructionsList.get(0));
    }

    @Test
    @DisplayName("execute GGG instructions")
        public void shouldBeNorth() throws IOException, MowerException {
        List<Mower> mowerList = mowerManager.extractAllMowers();
        MowerPosition mowerPosition = new MowerPosition(new CoordinatesPoint(1, 2), Direction.NORTH);

        Mower mowerExpected = mowerList.get(0);
        // execute mower instructions
        mowerExpected.simulateMower(mowerPosition, "GGG");
    }
}
