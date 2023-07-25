package StreamsFilesAndDirectoriesLab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class A02WriteToFile {

    public static void main(String[] args) {

        String filePath = "C:\\Users\\Chimi\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources";

        String readPath = filePath + "\\input.txt";
        String writePath = filePath + "\\output.txt";

        List<String> symbols = Arrays.asList(",", ".", "!", "?") ;

        try (FileInputStream fileInputStream = new FileInputStream(readPath)){

            int readByte = fileInputStream.read();


            try (FileOutputStream fileOutputStream = new FileOutputStream(writePath)){

                while (readByte >= 0){


                    if (!symbols.contains((char)readByte+"")){

                        fileOutputStream.write(readByte);

                    }

                    readByte = fileInputStream.read();
                }


            }catch (IOException e) {

                throw new RuntimeException(e);

            }





        } catch (IOException e) {

            throw new RuntimeException(e);

        }

    }
}
