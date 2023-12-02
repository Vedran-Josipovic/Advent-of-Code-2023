package Day2;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        File data = new File("Day2/data");
        Integer sum = 0;
        try (Scanner scanner = new Scanner(data)) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();

                String[] gameLine = line.split(": ");
                String[] subsets = gameLine[1].split("; ");

                Map<String, Integer> colorMins = new HashMap<>();
                colorMins.put("red", 0); colorMins.put("green", 0); colorMins.put("blue", 0);

                for (String set : subsets) {
                    String[] subset = set.split(", ");
                    for (var s : subset) {
                        String[] cube = s.split(" ");
                        int cubeCount = Integer.parseInt(cube[0]);
                        String cubeColor = cube[1];
                        colorMins.put(cubeColor, Math.max(colorMins.get(cubeColor), cubeCount));
                    }
                }
                sum += colorMins.get("red") * colorMins.get("blue") * colorMins.get("green");
            }
        } catch (FileNotFoundException e) {
            System.exit(-1);
        }
        System.out.println(sum);
    }
}
