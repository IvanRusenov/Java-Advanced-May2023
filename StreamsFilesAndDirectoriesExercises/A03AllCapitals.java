package StreamsFilesAndDirectoriesExercises;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class A03AllCapitals {

    public static void main(String[] args) throws IOException {

        String inPath = "C:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String outPath = "C:\\Users\\Chimi\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";
        OutputStream writer =  Files.newOutputStream(Path.of(outPath));

        for (byte b : Files.readAllBytes(Path.of(inPath))) {

            if (b >= 97 && b <= 122){

                writer.write(b-32);
                continue;

            }

                writer.write(b);

        }

    }
}
