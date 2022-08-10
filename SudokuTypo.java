import java.util.ArrayList;

public class SudokuTypo {
    public static int fix(int[] digits) {
        // Initialize integer array with 9 ints to count the occurrence of each number from 1-9.
        int[] numberCount = new int[9];
        // Using for each loop, iterate through the entire array of 81 elements to count the number of times each element has occurred.
        for (int x = 0; x < 81; x++) {
            // Since the correct elements are from 1-9 and index range is from 0-8, we can reduce 1 from the digit and use it as an array index to increase counter.
            numberCount[digits[x] - 1]++;
        }
//        System.out.println(Arrays.toString(numberCount));
        // Loop through the counter array to find out the missing correct digit
        for (int y = 0; y < 9; y++) {
            // The digit which has the count of 8 will be the missing correct digit
            // As, in a 9x9 sudoku puzzle, each element will occur 9 times.
            if (numberCount[y] == 8) {
                return y + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        // 35 test cases
        ArrayList<int[]> testCases = new ArrayList<>() {
            {
                add(new int[]{8, 6, 1, 2, 3, 4, 9, 5, 3, 4, 7, 9, 5, 6, 1, 2, 8, 3, 3, 2, 5, 9, 7, 8, 1, 6, 4, 9, 5, 8, 1, 4, 3, 6, 7, 2, 7, 1, 2, 8, 5, 6, 3, 4, 9, 6, 3, 4, 7, 2, 9, 5, 1, 8, 5, 9, 6, 4, 8, 2, 7, 3, 1, 1, 4, 3, 6, 9, 7, 8, 2, 5, 2, 8, 7, 3, 1, 5, 4, 9, 6});
                add(new int[]{8, 6, 1, 2, 3, 4, 9, 5, 7, 4, 7, 9, 5, 6, 1, 2, 8, 3, 3, 2, 5, 9, 7, 8, 1, 6, 4, 9, 5, 8, 1, 4, 3, 6, 7, 2, 7, 1, 2, 8, 1, 6, 3, 4, 9, 6, 3, 4, 7, 2, 9, 5, 1, 8, 5, 9, 6, 4, 8, 2, 7, 3, 1, 1, 4, 3, 6, 9, 7, 8, 2, 5, 2, 8, 7, 3, 1, 5, 4, 9, 6});
                add(new int[]{5, 3, 4, 6, 7, 8, 9, 1, 2, 6, 7, 2, 1, 9, 5, 3, 4, 8, 1, 9, 8, 3, 4, 2, 5, 6, 7, 8, 5, 9, 7, 6, 1, 4, 2, 3, 4, 2, 6, 8, 5, 3, 7, 9, 1, 7, 1, 3, 9, 2, 4, 8, 5, 6, 9, 6, 1, 5, 3, 7, 2, 8, 4, 2, 8, 7, 4, 1, 9, 1, 3, 5, 3, 4, 5, 2, 8, 6, 1, 7, 9});
                add(new int[]{5, 3, 8, 1, 2, 9, 7, 6, 7, 9, 6, 4, 5, 8, 7, 3, 1, 2, 1, 7, 2, 6, 3, 4, 8, 9, 5, 3, 4, 5, 7, 9, 8, 1, 2, 6, 6, 8, 9, 2, 1, 5, 4, 7, 3, 7, 2, 1, 4, 6, 3, 9, 5, 8, 8, 1, 3, 9, 5, 2, 6, 4, 7, 2, 9, 7, 3, 4, 6, 5, 8, 1, 4, 5, 6, 8, 7, 1, 2, 3, 9});
                add(new int[]{5, 3, 8, 1, 2, 9, 7, 6, 4, 9, 6, 4, 5, 8, 7, 3, 1, 2, 1, 7, 2, 6, 3, 4, 8, 9, 5, 3, 4, 5, 7, 9, 8, 1, 2, 6, 6, 8, 9, 2, 1, 5, 4, 7, 3, 7, 2, 1, 4, 6, 3, 9, 5, 8, 8, 1, 3, 9, 5, 2, 6, 4, 7, 2, 9, 7, 3, 4, 6, 5, 8, 1, 4, 6, 6, 8, 7, 1, 2, 3, 9});
                add(new int[]{5, 3, 8, 1, 2, 9, 7, 6, 4, 9, 6, 4, 5, 8, 7, 3, 1, 2, 1, 7, 2, 6, 3, 4, 8, 9, 5, 3, 4, 5, 7, 9, 8, 1, 2, 6, 6, 8, 9, 2, 1, 5, 4, 7, 3, 7, 2, 1, 4, 6, 1, 9, 5, 8, 8, 1, 3, 9, 5, 2, 6, 4, 7, 2, 9, 7, 3, 4, 6, 5, 8, 1, 4, 5, 6, 8, 7, 1, 2, 3, 9});
                add(new int[]{5, 3, 8, 2, 2, 9, 7, 6, 4, 9, 6, 4, 5, 8, 7, 3, 1, 2, 1, 7, 2, 6, 3, 4, 8, 9, 5, 3, 4, 5, 7, 9, 8, 1, 2, 6, 6, 8, 9, 2, 1, 5, 4, 7, 3, 7, 2, 1, 4, 6, 3, 9, 5, 8, 8, 1, 3, 9, 5, 2, 6, 4, 7, 2, 9, 7, 3, 4, 6, 5, 8, 1, 4, 5, 6, 8, 7, 1, 2, 3, 9});
                add(new int[]{6, 7, 5, 4, 9, 1, 2, 8, 3, 9, 4, 3, 6, 8, 2, 1, 7, 5, 8, 1, 2, 7, 5, 3, 6, 4, 9, 7, 9, 6, 3, 1, 8, 8, 5, 2, 4, 3, 8, 5, 2, 6, 9, 1, 7, 5, 2, 1, 9, 7, 4, 3, 6, 8, 2, 8, 7, 1, 6, 9, 5, 3, 4, 3, 6, 9, 8, 4, 5, 7, 2, 1, 1, 5, 4, 2, 3, 7, 8, 9, 6});
                add(new int[]{6, 7, 5, 4, 9, 1, 2, 8, 3, 9, 4, 3, 6, 8, 2, 1, 7, 5, 8, 1, 2, 7, 5, 3, 6, 4, 9, 7, 9, 6, 3, 1, 8, 4, 5, 2, 4, 3, 8, 5, 7, 6, 9, 1, 7, 5, 2, 1, 9, 7, 4, 3, 6, 8, 2, 8, 7, 1, 6, 9, 5, 3, 4, 3, 6, 9, 8, 4, 5, 7, 2, 1, 1, 5, 4, 2, 3, 7, 8, 9, 6});
                add(new int[]{6, 7, 5, 4, 9, 1, 2, 8, 3, 9, 4, 3, 6, 8, 2, 1, 7, 5, 8, 1, 2, 7, 5, 3, 6, 4, 9, 7, 9, 6, 9, 1, 8, 4, 5, 2, 4, 3, 8, 5, 2, 6, 9, 1, 7, 5, 2, 1, 9, 7, 4, 3, 6, 8, 2, 8, 7, 1, 6, 9, 5, 3, 4, 3, 6, 9, 8, 4, 5, 7, 2, 1, 1, 5, 4, 2, 3, 7, 8, 9, 6});
                add(new int[]{5, 3, 8, 1, 2, 9, 7, 6, 4, 9, 6, 4, 5, 8, 7, 3, 1, 2, 1, 7, 2, 6, 3, 4, 8, 9, 5, 3, 4, 5, 7, 9, 8, 1, 2, 6, 6, 8, 9, 2, 1, 5, 4, 7, 3, 7, 2, 1, 4, 6, 3, 9, 5, 8, 8, 1, 4, 9, 5, 2, 6, 4, 7, 2, 9, 7, 3, 4, 6, 5, 8, 1, 4, 5, 6, 8, 7, 1, 2, 3, 9});
                add(new int[]{6, 7, 5, 4, 9, 1, 2, 8, 3, 9, 4, 3, 6, 8, 2, 1, 7, 5, 8, 1, 2, 7, 5, 3, 6, 4, 9, 7, 9, 6, 3, 1, 8, 4, 5, 2, 4, 3, 8, 5, 2, 6, 9, 1, 7, 5, 2, 1, 9, 7, 4, 3, 6, 8, 2, 8, 7, 1, 6, 9, 5, 3, 4, 3, 6, 9, 8, 4, 5, 7, 2, 6, 1, 5, 4, 2, 3, 7, 8, 9, 6});
                add(new int[]{5, 3, 8, 1, 2, 9, 7, 6, 4, 9, 6, 4, 5, 8, 7, 3, 1, 2, 1, 7, 2, 6, 3, 4, 8, 9, 5, 3, 4, 5, 7, 9, 8, 1, 2, 6, 6, 8, 9, 2, 1, 5, 4, 7, 3, 7, 2, 1, 4, 6, 3, 9, 5, 8, 8, 1, 3, 9, 5, 2, 6, 4, 7, 2, 9, 7, 3, 4, 6, 5, 8, 1, 4, 5, 6, 8, 6, 1, 2, 3, 9});
                add(new int[]{6, 7, 5, 4, 9, 1, 2, 8, 3, 9, 4, 3, 6, 8, 2, 1, 7, 5, 8, 1, 2, 7, 5, 3, 6, 4, 9, 7, 9, 6, 1, 1, 8, 4, 5, 2, 4, 3, 8, 5, 2, 6, 9, 1, 7, 5, 2, 1, 9, 7, 4, 3, 6, 8, 2, 8, 7, 1, 6, 9, 5, 3, 4, 3, 6, 9, 8, 4, 5, 7, 2, 1, 1, 5, 4, 2, 3, 7, 8, 9, 6});
                add(new int[]{6, 7, 5, 4, 9, 1, 2, 8, 3, 9, 4, 3, 6, 8, 2, 1, 7, 5, 8, 1, 2, 7, 5, 3, 6, 4, 9, 7, 9, 6, 3, 1, 8, 4, 5, 2, 4, 3, 8, 5, 2, 6, 2, 1, 7, 5, 2, 1, 9, 7, 4, 3, 6, 8, 2, 8, 7, 1, 6, 9, 5, 3, 4, 3, 6, 9, 8, 4, 5, 7, 2, 1, 1, 5, 4, 2, 3, 7, 8, 9, 6});
                add(new int[]{5, 3, 8, 1, 2, 9, 7, 6, 4, 9, 6, 4, 5, 8, 7, 3, 1, 2, 1, 7, 2, 6, 3, 4, 8, 9, 5, 3, 4, 5, 7, 9, 8, 1, 2, 6, 6, 8, 9, 2, 1, 5, 4, 7, 3, 7, 2, 1, 4, 6, 3, 9, 5, 8, 8, 1, 3, 9, 5, 2, 6, 4, 7, 2, 9, 7, 3, 4, 6, 5, 8, 1, 4, 5, 7, 8, 7, 1, 2, 3, 9});
                add(new int[]{5, 3, 8, 1, 2, 9, 7, 6, 4, 9, 6, 4, 4, 8, 7, 3, 1, 2, 1, 7, 2, 6, 3, 4, 8, 9, 5, 3, 4, 5, 7, 9, 8, 1, 2, 6, 6, 8, 9, 2, 1, 5, 4, 7, 3, 7, 2, 1, 4, 6, 3, 9, 5, 8, 8, 1, 3, 9, 5, 2, 6, 4, 7, 2, 9, 7, 3, 4, 6, 5, 8, 1, 4, 5, 6, 8, 7, 1, 2, 3, 9});
                add(new int[]{5, 3, 8, 1, 2, 9, 7, 6, 4, 9, 6, 4, 5, 8, 7, 3, 1, 2, 1, 7, 2, 6, 3, 4, 8, 9, 5, 8, 4, 5, 7, 9, 8, 1, 2, 6, 6, 8, 9, 2, 1, 5, 4, 7, 3, 7, 2, 1, 4, 6, 3, 9, 5, 8, 8, 1, 3, 9, 5, 2, 6, 4, 7, 2, 9, 7, 3, 4, 6, 5, 8, 1, 4, 5, 6, 8, 7, 1, 2, 3, 9});
                add(new int[]{6, 7, 5, 4, 9, 1, 2, 8, 3, 9, 4, 3, 6, 8, 2, 1, 7, 5, 8, 1, 2, 7, 5, 3, 6, 4, 9, 7, 9, 6, 3, 1, 8, 4, 5, 2, 4, 3, 8, 5, 2, 6, 9, 1, 7, 5, 2, 1, 9, 7, 4, 3, 6, 6, 2, 8, 7, 1, 6, 9, 5, 3, 4, 3, 6, 9, 8, 4, 5, 7, 2, 1, 1, 5, 4, 2, 3, 7, 8, 9, 6});
                add(new int[]{5, 3, 8, 1, 2, 9, 7, 6, 4, 9, 6, 4, 5, 8, 7, 3, 1, 2, 1, 7, 2, 6, 3, 4, 8, 9, 5, 3, 4, 5, 9, 9, 8, 1, 2, 6, 6, 8, 9, 2, 1, 5, 4, 7, 3, 7, 2, 1, 4, 6, 3, 9, 5, 8, 8, 1, 3, 9, 5, 2, 6, 4, 7, 2, 9, 7, 3, 4, 6, 5, 8, 1, 4, 5, 6, 8, 7, 1, 2, 3, 9});
                add(new int[]{5, 3, 8, 1, 2, 9, 7, 6, 4, 9, 6, 4, 5, 8, 7, 3, 1, 2, 1, 7, 2, 6, 3, 4, 8, 9, 5, 3, 4, 5, 7, 9, 8, 1, 2, 6, 6, 8, 9, 2, 1, 5, 4, 7, 3, 9, 2, 1, 4, 6, 3, 9, 5, 8, 8, 1, 3, 9, 5, 2, 6, 4, 7, 2, 9, 7, 3, 4, 6, 5, 8, 1, 4, 5, 6, 8, 7, 1, 2, 3, 9});
                add(new int[]{6, 7, 5, 4, 9, 1, 2, 8, 3, 9, 4, 3, 6, 8, 2, 1, 7, 5, 8, 1, 2, 7, 5, 3, 6, 4, 9, 7, 9, 6, 3, 1, 8, 4, 5, 2, 4, 3, 8, 5, 2, 6, 9, 1, 7, 5, 2, 1, 9, 7, 4, 3, 6, 8, 2, 8, 7, 1, 6, 9, 5, 5, 4, 3, 6, 9, 8, 4, 5, 7, 2, 1, 1, 5, 4, 2, 3, 7, 8, 9, 6});
                add(new int[]{5, 3, 8, 1, 2, 9, 7, 6, 4, 9, 6, 4, 5, 8, 7, 3, 1, 2, 1, 7, 2, 6, 3, 4, 8, 9, 5, 3, 4, 5, 7, 9, 8, 9, 2, 6, 6, 8, 9, 2, 1, 5, 4, 7, 3, 7, 2, 1, 4, 6, 3, 9, 5, 8, 8, 1, 3, 9, 5, 2, 6, 4, 7, 2, 9, 7, 3, 4, 6, 5, 8, 1, 4, 5, 6, 8, 7, 1, 2, 3, 9});
                add(new int[]{6, 7, 5, 4, 9, 1, 2, 8, 3, 9, 4, 3, 6, 8, 2, 1, 7, 5, 8, 1, 2, 7, 5, 3, 6, 4, 9, 7, 9, 6, 3, 1, 8, 4, 5, 2, 4, 3, 8, 5, 2, 6, 9, 1, 7, 5, 2, 1, 9, 7, 4, 3, 6, 8, 2, 8, 7, 1, 6, 9, 5, 3, 4, 3, 6, 9, 8, 4, 5, 7, 2, 1, 1, 5, 4, 2, 3, 2, 8, 9, 6});
                add(new int[]{6, 7, 5, 4, 9, 1, 2, 8, 3, 9, 4, 3, 6, 8, 2, 1, 7, 5, 8, 1, 2, 7, 5, 3, 6, 4, 9, 7, 9, 6, 3, 1, 8, 4, 5, 2, 4, 3, 8, 5, 2, 6, 9, 1, 7, 5, 2, 1, 8, 7, 4, 3, 6, 8, 2, 8, 7, 1, 6, 9, 5, 3, 4, 3, 6, 9, 8, 4, 5, 7, 2, 1, 1, 5, 4, 2, 3, 7, 8, 9, 6});
                add(new int[]{5, 3, 8, 1, 2, 9, 7, 6, 4, 9, 6, 4, 5, 8, 7, 3, 1, 2, 1, 7, 2, 6, 3, 4, 8, 9, 5, 3, 4, 5, 7, 9, 8, 1, 2, 6, 6, 8, 9, 2, 1, 5, 4, 7, 3, 7, 2, 1, 4, 6, 3, 9, 5, 8, 8, 1, 3, 9, 5, 2, 6, 4, 7, 2, 9, 7, 3, 4, 6, 5, 8, 1, 4, 5, 6, 8, 7, 9, 2, 3, 9});
                add(new int[]{6, 7, 5, 4, 9, 1, 2, 8, 3, 9, 4, 3, 6, 8, 2, 1, 7, 5, 8, 1, 2, 7, 5, 3, 6, 4, 9, 7, 9, 6, 3, 1, 8, 4, 5, 2, 4, 3, 8, 5, 2, 6, 9, 1, 7, 5, 2, 1, 9, 7, 4, 3, 6, 8, 2, 8, 1, 1, 6, 9, 5, 3, 4, 3, 6, 9, 8, 4, 5, 7, 2, 1, 1, 5, 4, 2, 3, 7, 8, 9, 6});
                add(new int[]{6, 7, 5, 4, 9, 1, 2, 8, 3, 5, 4, 3, 6, 8, 2, 1, 7, 5, 8, 1, 2, 7, 5, 3, 6, 4, 9, 7, 9, 6, 3, 1, 8, 4, 5, 2, 4, 3, 8, 5, 2, 6, 9, 1, 7, 5, 2, 1, 9, 7, 4, 3, 6, 8, 2, 8, 7, 1, 6, 9, 5, 3, 4, 3, 6, 9, 8, 4, 5, 7, 2, 1, 1, 5, 4, 2, 3, 7, 8, 9, 6});
                add(new int[]{5, 3, 8, 1, 2, 9, 7, 6, 4, 9, 6, 4, 5, 8, 7, 3, 1, 2, 1, 7, 2, 6, 3, 4, 8, 9, 5, 3, 4, 5, 7, 9, 8, 1, 2, 6, 6, 8, 9, 2, 1, 5, 4, 7, 3, 7, 2, 1, 4, 6, 3, 9, 5, 8, 8, 6, 3, 9, 5, 2, 6, 4, 7, 2, 9, 7, 3, 4, 6, 5, 8, 1, 4, 5, 6, 8, 7, 1, 2, 3, 9});
                add(new int[]{6, 7, 5, 4, 9, 1, 2, 8, 3, 9, 4, 3, 6, 8, 2, 1, 7, 5, 8, 1, 2, 7, 5, 3, 6, 4, 9, 7, 9, 6, 3, 1, 8, 4, 5, 2, 4, 3, 8, 5, 2, 6, 9, 1, 7, 5, 2, 1, 9, 7, 4, 3, 6, 8, 2, 8, 7, 1, 6, 9, 5, 3, 4, 3, 6, 9, 8, 4, 5, 7, 2, 1, 1, 5, 4, 2, 3, 5, 8, 9, 6});
                add(new int[]{5, 3, 8, 1, 2, 9, 7, 6, 4, 9, 6, 4, 5, 8, 7, 3, 1, 2, 1, 7, 2, 6, 3, 4, 8, 9, 5, 3, 4, 5, 7, 9, 8, 1, 2, 6, 6, 8, 9, 2, 1, 5, 4, 7, 3, 7, 2, 1, 4, 6, 3, 9, 5, 8, 8, 1, 3, 9, 5, 2, 6, 4, 7, 2, 9, 7, 3, 4, 6, 5, 8, 1, 4, 4, 6, 8, 7, 1, 2, 3, 9});
                add(new int[]{6, 7, 5, 4, 9, 1, 2, 8, 3, 9, 4, 3, 6, 8, 2, 1, 7, 5, 8, 1, 2, 7, 5, 3, 6, 4, 9, 7, 9, 6, 3, 1, 8, 4, 5, 2, 4, 3, 8, 5, 2, 6, 9, 1, 7, 5, 2, 1, 9, 7, 4, 3, 6, 8, 2, 8, 7, 1, 6, 9, 4, 3, 4, 3, 6, 9, 8, 4, 5, 7, 2, 1, 1, 5, 4, 2, 3, 7, 8, 9, 6});
                add(new int[]{6, 7, 5, 4, 9, 1, 2, 8, 3, 9, 4, 3, 3, 8, 2, 1, 7, 5, 8, 1, 2, 7, 5, 3, 6, 4, 9, 7, 9, 6, 3, 1, 8, 4, 5, 2, 4, 3, 8, 5, 2, 6, 9, 1, 7, 5, 2, 1, 9, 7, 4, 3, 6, 8, 2, 8, 7, 1, 6, 9, 5, 3, 4, 3, 6, 9, 8, 4, 5, 7, 2, 1, 1, 5, 4, 2, 3, 7, 8, 9, 6});
                add(new int[]{8, 6, 1, 2, 3, 4, 9, 5, 3, 4, 7, 9, 5, 6, 1, 2, 8, 3, 3, 2, 5, 9, 7, 8, 1, 6, 4, 9, 5, 8, 1, 4, 3, 6, 7, 2, 7, 1, 2, 8, 5, 6, 3, 4, 9, 6, 3, 4, 7, 2, 9, 5, 1, 8, 5, 9, 6, 4, 8, 2, 7, 3, 1, 1, 4, 3, 6, 9, 7, 8, 2, 5, 2, 8, 7, 3, 1, 5, 4, 9, 6});
                add(new int[]{8, 6, 1, 2, 3, 4, 9, 5, 7, 4, 7, 9, 5, 6, 1, 2, 8, 3, 3, 2, 5, 9, 7, 8, 1, 6, 4, 9, 5, 8, 1, 4, 3, 6, 7, 2, 7, 1, 2, 8, 1, 6, 3, 4, 9, 6, 3, 4, 7, 2, 9, 5, 1, 8, 5, 9, 6, 4, 8, 2, 7, 3, 1, 1, 4, 3, 6, 9, 7, 8, 2, 5, 2, 8, 7, 3, 1, 5, 4, 9, 6});
            }
        };

        for (int[] testCase : testCases) {
            System.out.println(fix(testCase));
        }
    }
}
