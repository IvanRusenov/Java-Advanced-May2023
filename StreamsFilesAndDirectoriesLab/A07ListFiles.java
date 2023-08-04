package StreamsFilesAndDirectoriesLab;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class A07ListFiles {

    public static void main(String[] args) throws IOException {

        String path = "C:\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";

        File file = new File(path);

        File[] files = file.listFiles();

        if (files != null) {
            for (File file1 : files) {
                if (file1.isFile()){
                    System.out.printf("%s: [%d]\n", file1.getName(), file1.length());
                }
            }
        }


    }
}
