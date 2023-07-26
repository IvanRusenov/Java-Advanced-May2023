package StreamsFilesAndDirectoriesLab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class A03CopyBytes {

    public static void main(String[] args) {

        String filePath = "C:\\Users\\Chimi\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources";

        String readPath = filePath + "\\input.txt";
        String writePath = filePath + "\\output1.txt";

        try (FileInputStream in = new FileInputStream(readPath)) {

            int oneByte = in.read();

            try (FileOutputStream out = new FileOutputStream(writePath)) {

                while (oneByte >= 0) {

                    if (oneByte != 32 && oneByte != 10) {

                        String str = String.valueOf(oneByte);

                        for (int i = 0; i < str.length(); i++) {

                            out.write(str.charAt(i));
                        }

                    } else {

                        out.write(oneByte);

                    }

                    oneByte = in.read();

                }

            } catch (IOException e) {

                throw new RuntimeException(e);

            }

        } catch (IOException e) {

            throw new RuntimeException(e);

        }

    }
}
