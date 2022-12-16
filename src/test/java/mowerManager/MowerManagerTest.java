package mowerManager;

import com.company.tondeuse.enums.Direction;
import com.company.tondeuse.exception.MowerException;
import com.company.tondeuse.models.*;
import com.company.tondeuse.tranverse.Constants;
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
    @DisplayName("execute instructions mower 1")
    public void executeInstructionsMower1() throws IOException, MowerException {
        List<Mower> mowerList = mowerManager.extractAllMowers();
        List<String> instructionsList = mowerManager.selectAllInstructions();
        // CoordinatesPoint mower 1
        CoordinatesPoint coordinatesMower1 = mowerList.get(0).getCoordinatesPoint();
        // Direction mower 1
        Direction directionMower1 = mowerList.get(0).getDirection();
        Assert.assertEquals(directionMower1, Direction.NORTH);
        Assert.assertEquals(coordinatesMower1, new CoordinatesPoint(1,2));

        MowerPosition mowerPosition1 = new MowerPosition(coordinatesMower1, directionMower1);

        // Mower 1
        Mower mower1 = mowerList.get(0);
        MowerPosition lastMowerPosition1 = mower1.simulateMower(mowerPosition1, instructionsList.get(0));
        String resultMowerPosition1 = lastMowerPosition1.getCoordinates().getX()+" "+lastMowerPosition1.getCoordinates().getY()+" "+lastMowerPosition1.getMowerDirection().getCode();
        Assert.assertEquals(resultMowerPosition1, "1 3 N");
        System.out.println("Final Position Mower 1: "+"(X = "+lastMowerPosition1.getCoordinates().getX() + ", Y=" +lastMowerPosition1.getCoordinates().getY()+" )" +" Direction = "+mower1.getDirection().getCode());
    }
    @Test
    @DisplayName("execute instructions mower 2")
    public void executeInstructionsMower2() throws IOException, MowerException {
        List<Mower> mowerList = mowerManager.extractAllMowers();
        List<String> instructionsList = mowerManager.selectAllInstructions();
        // CoordinatesPoint mower 2
        CoordinatesPoint coordinatesMower2 = mowerList.get(1).getCoordinatesPoint();
        // Direction mower 2
        Direction directionMower2 = mowerList.get(1).getDirection();
        Assert.assertEquals(directionMower2, Direction.EAST);
        Assert.assertEquals(coordinatesMower2, new CoordinatesPoint(3,3));

        MowerPosition mowerPosition2 = new MowerPosition(coordinatesMower2, directionMower2);
        // Mower 2
        Mower mower2 = mowerList.get(1);
        MowerPosition lastPositionMower2 = mower2.simulateMower(mowerPosition2, instructionsList.get(1));
        String resultPositionMower2 = lastPositionMower2.getCoordinates().getX()+" "+lastPositionMower2.getCoordinates().getY()+" "+lastPositionMower2.getMowerDirection().getCode();
        Assert.assertEquals(resultPositionMower2, "5 1 E");

        System.out.println("Final Position Mower 2: "+"(X = "+lastPositionMower2.getCoordinates().getX() + ", Y=" +lastPositionMower2.getCoordinates().getY()+" )" +" Direction = "+mower2.getDirection().getCode());
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
