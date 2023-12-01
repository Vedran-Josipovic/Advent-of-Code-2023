package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Task2 {
    public static void main(String[] args) {
        File data = new File("Day1/data");
        Scanner scanner = null;
        try {
            scanner = new Scanner(data);
        } catch (FileNotFoundException e) {
            System.exit(-1);
        }
        int sum = 0;
        while (scanner.hasNext()) {
            String line = scanner.nextLine();

            Map<Integer, Integer> startAndLength = new TreeMap<>();
            List<String> stringValues = List.of("one", "two", "three", "four", "five", "six", "seven", "eight", "nine");
            List<String> digitValues = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9");
            Map<String, Integer> mapper = new HashMap<>();
            for (int i = 0; i < 9; i++) {
                mapper.put(stringValues.get(i), i + 1);
                mapper.put(digitValues.get(i), i + 1);
            }

            List<String> validValues = new ArrayList<>();
            validValues.addAll(stringValues);
            validValues.addAll(digitValues);

            for (var e : validValues) {
                int index = 0;
                while (index != -1) {
                    if ((index = line.indexOf(e, index)) != -1) {
                        startAndLength.put(index, e.length());
                        index += e.length();
                    }
                }
            }

            List<String> filteredValues = new ArrayList<>();
            for (var e : startAndLength.entrySet()) {
                Integer start = e.getKey();
                Integer end = e.getValue();
                filteredValues.add(line.substring(start, start + end));
            }
            List<Integer> intValues = filteredValues.stream()
                    .map(mapper::get)
                    .collect(Collectors.toList());

            sum += (intValues.getFirst() * 10) + intValues.getLast();
            System.out.println(intValues);
        }
        System.out.println("Sum: " + sum);
    }
}
