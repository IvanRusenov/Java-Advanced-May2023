package StreamsFilesAndDirectoriesLab;

import java.io.*;

public class A05WriteEveryThirdLine {

    public static void main(String[] args){

        String filePath = "C:\\04. Java-Advanced-Files-and-Streams-Lab-Resources";
        String readPath = filePath + "\\input.txt";
        String writePath = filePath + "\\output1.txt";

        try(BufferedReader reader = new BufferedReader(new FileReader(readPath));

            PrintStream write = new PrintStream(writePath)){

            String line = reader.readLine();

            int count = 0;

            while (line != null){

                count++;

                if (count % 3 == 0){

                    write.println(line);

                }

                line = reader.readLine();

            }

        } catch (IOException e) {

            throw new RuntimeException(e);

        }

    }
}
