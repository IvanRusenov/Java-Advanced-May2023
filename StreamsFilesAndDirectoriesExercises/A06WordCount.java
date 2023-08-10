package StreamsFilesAndDirectoriesExercises;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class A06WordCount {

    public static void main(String[] args) {

        String inPath = "C:\\Users\\Chimi\\Desktop\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";

        String inPath2 = "C:\\Users\\Chimi\\Desktop\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";

        String outPath = "C:\\Users\\Chimi\\Desktop\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\results.txt";

        Map<String, Integer> wordsMap = new HashMap<>();

        try (BufferedReader reader = Files.newBufferedReader(Path.of(inPath));
             BufferedReader reader2 = Files.newBufferedReader(Path.of(inPath2));
             BufferedWriter writer = Files.newBufferedWriter(Path.of(outPath))) {

            List<String> wordsList = new ArrayList<>();
            String line = reader.readLine();

            while (line != null) {

                wordsList.addAll(Arrays.stream(line.split("\\s+")).toList());
                line = reader.readLine();

            }

            StringBuilder sb = new StringBuilder();
           line = reader2.readLine();

            while (line != null) {

                sb.append(line);
                line = reader2.readLine();

            }

            String text = sb.toString();
            List<String> textAsWords = Arrays.stream(text.split("\\s+")).toList();

            for (String word : wordsList) {
                for (String textWord : textAsWords) {
                    if (textWord.equals(word)) {
                        wordsMap.putIfAbsent(word, 0);
                        wordsMap.put(word, wordsMap.get(word) + 1);
                    }
                }
            }


            wordsMap.entrySet().stream()
                    .sorted((f, s) -> s.getValue().compareTo(f.getValue()))
                    .forEach(entry -> {
                        try {

                            writer.write(entry.getKey() + " - " + entry.getValue() + System.lineSeparator());

                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
