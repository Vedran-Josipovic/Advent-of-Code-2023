package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        File data = new File("Day2/data");
        Integer sum = 0;
        try (Scanner scanner = new Scanner(data)) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();

                String[] gameLine = line.split(": ");
                int id = Integer.parseInt(gameLine[0].replaceFirst("Game ", ""));
                String[] subsets = gameLine[1].split("; ");

                Map<String, Integer> colorMaxes = new HashMap<>();
                colorMaxes.put("red", 0); colorMaxes.put("green", 0); colorMaxes.put("blue", 0);

                for (String set : subsets) {
                    String[] subset = set.split(", ");
                    for (var s : subset) {
                        String[] cube = s.split(" ");
                        int cubeCount = Integer.parseInt(cube[0]);
                        String cubeColor = cube[1];
                        colorMaxes.put(cubeColor, Math.max(colorMaxes.get(cubeColor), cubeCount));
                    }
                }
                if (colorMaxes.get("red") <= 12 && colorMaxes.get("green") <= 13 && colorMaxes.get("blue") <= 14) sum += id;
            }
        } catch (FileNotFoundException e) {
            System.exit(-1);
        }


        System.out.println(sum);
    }

}
