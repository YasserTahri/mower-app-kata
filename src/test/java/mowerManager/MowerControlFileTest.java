package mowerManager;

import com.company.tondeuse.tranverse.Constants;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.io.File;
import java.io.IOException;

public class MowerControlFileTest {

    @Test
    @DisplayName("file must not be empty")
    public void fileShouldNotEmpty() throws IOException {
        File file = new java.io.File(Constants.file);
        long length = file.length();
        System.out.println(length);
        Assert.assertNotEquals(0, length);
    }

    @Test
    @DisplayName("Check if file text exist !")
    public void checkFileExist(){
        File file = new java.io.File(Constants.file);
        Assert.assertTrue(file.isFile());
    }
}
