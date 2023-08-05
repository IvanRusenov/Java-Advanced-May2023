package StreamsFilesAndDirectoriesExercises;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class A01SumLines {

    public static void main(String[] args) throws IOException {

        String path = "C:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        List<String> lines = Files.readAllLines(Path.of(path));

        lines.forEach(line -> {

            int sum =0;

            for (int i = 0; i < line.length(); i++) {

                sum += line.charAt(i);

            }

            System.out.println(sum);

        });

    }
}
