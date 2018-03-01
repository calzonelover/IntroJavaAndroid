/// File IO module
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
///

public class  MyMain {
    public static void main(String[] args) {
        try {
            Path file = Paths.get("/Users/jab/Desktop/Java/5_File(2)/example.txt");
            BufferedReader reader = Files.newBufferedReader(file, StandardCharsets.UTF_8);
            String line = null;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage()); 
        }
    }
}
