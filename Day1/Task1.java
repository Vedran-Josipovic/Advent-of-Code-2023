package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        File data = new File("Day1/data");
        Scanner scanner = null;
        try {
            scanner = new Scanner(data);
        } catch (FileNotFoundException e) {
            System.exit(-1);
        }
        Integer sum = 0;
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            List<Integer> characters = line
                    .chars()
                    .filter(i -> i >= 48 && i <= 57)
                    .map(i -> i - 48)
                    .boxed().toList();
            sum += (characters.getFirst() * 10) + characters.getLast();
        }
        System.out.println(sum);
    }
}
