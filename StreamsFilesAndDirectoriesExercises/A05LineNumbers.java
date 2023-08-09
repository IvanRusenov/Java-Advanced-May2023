package StreamsFilesAndDirectoriesExercises;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class A05LineNumbers {

    public static void main(String[] args) throws IOException {

        String inPath = "C:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";

        String outPath = "C:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";

        try (BufferedReader reader = Files.newBufferedReader(Path.of(inPath));
             BufferedWriter writer = Files.newBufferedWriter(Path.of(outPath))) {

            String line = reader.readLine();
            int counter = 1;

            while (line != null){

                String output = String.format("%d. %s\n", counter, line);

                writer.write(output);
                counter++;

                line = reader.readLine();
            }


        }


    }
}
