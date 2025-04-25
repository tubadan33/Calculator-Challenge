package src;

import java.util.Arrays;
import java.util.List;

public class Utils {
    private static final int PERMITTED_ARG_LENGTH = 2;

    public static void argsLenCheck(String input) {
        String[] args = input.split(",");
        if (args.length > PERMITTED_ARG_LENGTH) {
            throw new IllegalArgumentException("Too many args.");
        }
    }

    public static List<Integer> parseInput(String input) {
        if (input.startsWith("//")) {
            String delimiter = parseDelimiter(input);
            String numString = input.substring(input.indexOf("\n") + 1);
            return Arrays.stream(numString.split(delimiter))
                         .map(i -> parseNumber(i.trim())).toList();
        }
        return Arrays.stream(input.split(",|[\n]"))
                     .map(i -> parseNumber(i.trim())).toList();
    }

    public static String parseDelimiter(String input) {
        if (input.charAt(2) == '[') {
            return input.substring(3, input.indexOf("]"));
        }
        return input.substring(2, input.indexOf("\n"));
    }

    public static int parseNumber(String stringToParse) {
        if (isNumeric(stringToParse)) {
            int number = Integer.parseInt(stringToParse);
            if (number > 1000) {
                return 0;
            }
            return number;
        }
        return 0;
    }

    public static int sum(List<Integer> numsToSum) {
        return numsToSum.stream().reduce(0, Integer::sum);
    }

    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\d+)?");
    }

    public static void negativeNumberCheck(List<Integer> numsToCheck) {
        List<Integer> negativeNums = numsToCheck.stream().filter(num -> num < 0).toList();
        if (!negativeNums.isEmpty()) {
            throw new IllegalArgumentException("Negative numbers are not allowed. " + negativeNums);
        }
    }
}
