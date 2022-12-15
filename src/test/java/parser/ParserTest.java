package parser;


import com.company.tondeuse.enums.Direction;
import com.company.tondeuse.enums.MowerInstruction;
import com.company.tondeuse.models.CoordinatesPoint;
import com.company.tondeuse.models.Lawn;
import com.company.tondeuse.models.Mower;
import com.company.tondeuse.utils.Parser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.List;

public class ParserTest {

    @Test
    @DisplayName("parse lawn")
    public void shouldGetLawnAfterParse(){
        Lawn lawn = new Lawn(5, 5);
        String firstLineInFile = "5 5";
        Lawn parsedLawn = Parser.parseLawn(firstLineInFile);
        Assert.assertEquals(parsedLawn, lawn);
    }
    @Test
    @DisplayName("parse mower")
    public void shouldGetMowerAfterParse(){
      String data = "1 2 N";
      Lawn lawn1 = new Lawn(5,5);
      Mower parsedMower = Parser.parseMower(data, lawn1);
      Assert.assertEquals(Direction.NORTH, parsedMower.getDirection());
      Assert.assertEquals(new CoordinatesPoint(1,2), parsedMower.getCoordinatesPoint());
    }
    @Test
    @DisplayName("parse mower")
    public void shouldGetInstructions(){
        String instructions = "GAGAGAGAA";
        List<MowerInstruction> parsedInstructions = Parser.parseInstructions(instructions);
        Assert.assertEquals(parsedInstructions.size(), 9);
        Assert.assertEquals(parsedInstructions.get(0), MowerInstruction.LEFT);
    }

}
