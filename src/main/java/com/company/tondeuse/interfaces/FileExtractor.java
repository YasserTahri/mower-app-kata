package com.company.tondeuse.interfaces;

import com.company.tondeuse.models.Lawn;
import com.company.tondeuse.models.Mower;

import java.io.IOException;
import java.util.List;

public interface FileExtractor {

    void extractData() throws IOException;
    Lawn extractLawnFromFile() throws IOException;
    List<Mower> extractAllMowers() throws IOException;
    List<String> selectAllInstructions();
}
