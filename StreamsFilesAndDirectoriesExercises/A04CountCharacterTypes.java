package StreamsFilesAndDirectoriesExercises;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class A04CountCharacterTypes {

    public static void main(String[] args) throws IOException {

        String inPath = "C:\\Users\\Chimi\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String outPath = "C:\\Users\\Chimi\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";

        try (BufferedReader reader = Files.newBufferedReader(Path.of(inPath));
             PrintWriter writer = new PrintWriter(Files.newBufferedWriter(Path.of(outPath)))) {

            int read = reader.read();
            int vowels = 0;
            int symbols = 0;
            int punctuation = 0;

            while (read > 0){

                if (isVowel(read)){
                    vowels++;
                } else if (isPunctuation(read)) {
                    punctuation++;
                } else if (read != ' ' && read != '\n' && read != '\r') {
                    symbols++;
                }

                read = reader.read();

            }

            String output = String.format("Vowels: %d\nOther symbols: %d\nPunctuation: %d\n"
                    , vowels, symbols, punctuation);

            writer.write(output);


        }
    }

    private static boolean isVowel(int n){
        return n == 'a' || n == 'o' || n == 'u' || n == 'e' || n == 'i';
    }

    private static boolean isPunctuation(int n){
        return n == '.' || n == ',' || n == '?' || n == '!';
    }




}
