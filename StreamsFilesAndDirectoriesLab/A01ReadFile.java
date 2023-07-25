package StreamsFilesAndDirectoriesLab;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class A01ReadFile {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String filePath = "C:\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        try (InputStream inputStream = new FileInputStream(filePath)) {

            int firstByte = inputStream.read();

            while (firstByte >= 0){

                System.out.printf("%s ", Integer.toBinaryString(firstByte));
                firstByte= inputStream.read();

            }

        } catch (IOException e) {

            throw new RuntimeException(e);

        }

    }
}
