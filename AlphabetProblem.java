public class AlphabetProblem {
    public static int maxPref(String s) {
        // Convert all 26 correct digits of the alphabet to the char array to match with string
        char[] correctArray = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        // Convert given string to char array
        char[] givenStringArray = s.toCharArray();
        int count = 0;
        // Run for loop till the length of given string
        for (int x = 0; x < givenStringArray.length; x++) {
            // Match the chars in given string with the chars in the correct string
            if (givenStringArray[x] != correctArray[x]) {
                return count;
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        // 45 test cases
        String[] testCases = new String[]{
                "abctyf",
                "abcdefghijklmnopqrstuvwxyz",
                "zyx",
                "abcdegfhijk",
                "ba",
                "aabc",
                "abcdefghijklmno",
                "a",
                "b",
                "z",
                "aa",
                "bb",
                "edcba",
                "abcdefhij",
                "abcdefhijg",
                "cabd",
                "ab",
                "abb",
                "abc",
                "abcm",
                "abcd",
                "abcdz",
                "abcde",
                "abcdeb",
                "abcdef",
                "abcdefm",
                "abcdefg",
                "abcdefgw",
                "abcdefgh",
                "abcdefghe",
                "abcdefghi",
                "abcdefghiy",
                "abcdefghij",
                "abcdefghijy",
                "abcdefghijk",
                "abcdefghijkd",
                "abcdefghijkl",
                "abcdefghijkli",
                "abcdefghijklm",
                "abcdefghijklma",
                "abcdefghijklmn",
                "abcdefghijklmnd",
                "abcdefghijklmno",
                "abcdefghijklmnot",
                "abcdefghijklmnop",
        };
        for (String testCase : testCases) {
            System.out.println(maxPref(testCase));
        }
    }
}
