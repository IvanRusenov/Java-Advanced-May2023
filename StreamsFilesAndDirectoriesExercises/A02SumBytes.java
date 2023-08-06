package StreamsFilesAndDirectoriesExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class A02SumBytes {

    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\Chimi\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        try (BufferedReader reader = Files.newBufferedReader(Path.of(path))) {

            int oneByte = reader.read();
            long sum = 0;

            while (oneByte > 0) {

                if (oneByte != 10 && oneByte != 13){

                    sum += oneByte;

                }

                oneByte = reader.read();

            }

            System.out.println(sum);

        }
    }
}
