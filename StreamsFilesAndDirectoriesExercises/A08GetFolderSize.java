package StreamsFilesAndDirectoriesExercises;

import java.io.File;

public class A08GetFolderSize {

    public static void main(String[] args) {

        String path = "C:\\Users\\Chimi\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";

        File folder = new File(path);
        File[] files = folder.listFiles();

        int folderSize = 0;

        if (files != null) {
            for (File file : files) {

                folderSize += file.length();

            }
        }

        System.out.printf("Folder size: %d", folderSize);

    }
}
