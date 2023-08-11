package StreamsFilesAndDirectoriesExercises;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class A07MergeTwoFiles {

    public static void main(String[] args) {

        String inPath = "C:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";

        String inPath2 = "C:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt";

        String outPath = "C:\\Users\\Chimi\\Desktop\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\results.txt";

        try (BufferedReader reader = Files.newBufferedReader(Path.of(inPath));
             BufferedReader reader2 = Files.newBufferedReader(Path.of(inPath2));
             BufferedWriter writer = Files.newBufferedWriter(Path.of(outPath))) {

            String line = reader.readLine();

            while (line != null) {

                writer.write(line + System.lineSeparator());
                line = reader.readLine();

            }

            line = reader2.readLine();

            while (line != null) {

                writer.write(line + System.lineSeparator());
                line = reader2.readLine();

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
