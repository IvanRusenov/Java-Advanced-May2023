package StreamsFilesAndDirectoriesLab;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class A06SortLines {

    public static void main(String[] args) throws IOException {

        String filePath = "C:\\04. Java-Advanced-Files-and-Streams-Lab-Resources";
        String readPath = filePath + "\\input.txt";
        String writePath = filePath + "\\output1.txt";
        Path inputPath = Paths.get(readPath);
        Path outputPath = Paths.get(writePath);

        List<String> allLines = Files.readAllLines(inputPath).stream().sorted().collect(Collectors.toList());
        Files.write(outputPath, allLines);

    }
}
