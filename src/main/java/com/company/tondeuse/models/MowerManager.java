package com.company.tondeuse.models;

import com.company.tondeuse.interfaces.FileExtractor;
import com.company.tondeuse.tranverse.Constants;
import com.company.tondeuse.utils.FileReaderInput;
import com.company.tondeuse.utils.Parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MowerManager implements FileExtractor {

    String[] data;

    @Override
    public void extractData() throws IOException {
        data= FileReaderInput.loadFile().split(Constants.CR_SEPARTOR);
    }
    @Override
    public Lawn extractLawnFromFile() throws IOException {
        return Parser.parseLawn(data[0]);
    }
    @Override
    public List<Mower> extractAllMowers() throws IOException {
        return this.buildListMowers(data);
    }
    @Override
    public List<String> selectAllInstructions() {
       List<String> instructionsTab = new ArrayList<>();
        for(int i = 0, j = 0; i < data.length; i++){
            if(data[i].contains("A")|| data[i].contains("D")|| data[i].contains("G") ){
                instructionsTab.add(data[i]);
            }
        }
        return instructionsTab;
    }
    private List<Mower> buildListMowers(String[] data) throws IOException {
        Lawn lawn = extractLawnFromFile();
        return Arrays.asList(Parser.parseMower(data[1], lawn), Parser.parseMower(data[3], lawn));
    }
}
