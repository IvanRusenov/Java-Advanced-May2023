package StreamsFilesAndDirectoriesLab;

import java.io.*;
import java.util.Scanner;

public class A04ExtractIntegers {

    public static void main(String[] args) throws FileNotFoundException {

        String filePath = "C:\\04. Java-Advanced-Files-and-Streams-Lab-Resources";
        String readPath = filePath + "\\input.txt";
        String writePath = filePath + "\\output1.txt";

        Scanner reader = new Scanner(new FileInputStream(readPath));
        PrintStream writer = new PrintStream(new FileOutputStream(writePath));

        while (reader.hasNext()) {

            if (reader.hasNextInt()) {

                writer.println(reader.nextInt());

            }

            reader.next();

        }

    }
}
