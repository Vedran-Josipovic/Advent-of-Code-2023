package Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        File data = new File("Day3/data");
        try (Scanner scanner = new Scanner(data)) {
            String line = scanner.nextLine();
        } catch (FileNotFoundException e) {
            System.exit(-1);
        }
    }
}
