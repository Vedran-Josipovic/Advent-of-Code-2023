package Day3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        File data = new File("Day3/data");
        List<char[]> gridList = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(data))) {
            String line;
            while ((line = in.readLine()) != null) gridList.add(line.toCharArray());
        } catch (IOException e) {
            System.exit(-1);
        }
        char[][] grid = gridList.toArray(new char[0][]);
        int rows = grid.length, cols = grid[0].length;
        int[] dirX = {-1, 0, 1, 0, -1, -1, 1, 1};
        int[] dirY = {0, 1, 0, -1, -1, 1, -1, 1};
        List<String> validNumbersStr = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            StringBuilder number = new StringBuilder();
            boolean isNumberTouchingSymbol = false;
            for (int j = 0; j < cols; j++) {
                if (Character.isDigit(grid[i][j])) {
                    number.append(grid[i][j]);
                    for (int k = 0; k < 8; k++) {
                        int newX = i + dirX[k];
                        int newY = j + dirY[k];
                        if ((newX >= 0 && newX < rows && newY >= 0 && newY < cols) && (!Character.isDigit(grid[newX][newY]) && grid[newX][newY] != '.')) {
                            isNumberTouchingSymbol = true;
                        }
                    }
                } else {
                    if (isNumberTouchingSymbol) {
                        validNumbersStr.add(number.toString());
                    }
                    number = new StringBuilder();
                    isNumberTouchingSymbol = false;
                }
            }
            if (isNumberTouchingSymbol) {
                validNumbersStr.add(number.toString());
            }
        }

        List<Integer> validNumbers = validNumbersStr.stream().mapToInt(Integer::parseInt).boxed().toList();
        Integer sum = validNumbers.stream().reduce(Integer::sum).orElse(0);
        System.out.println(sum);
    }
}
