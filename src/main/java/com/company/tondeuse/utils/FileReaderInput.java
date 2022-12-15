package com.company.tondeuse.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileReaderInput {

    public FileReaderInput() {
    }

    public static String loadFile() throws IOException {
        StringBuilder sb = new StringBuilder();
        String file = "src/main/resources/file.txt";
        Path path = Paths.get(file);
        Stream<String> lines = Files.lines(path);

        lines.forEach(s -> sb.append(s).append("\n"));
        lines.close();
        return sb.toString();
    }
}
