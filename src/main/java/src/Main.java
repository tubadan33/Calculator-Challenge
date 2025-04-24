package src;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        List<Integer> parsed = Utils.parseInput(input);
        Utils.negativeNumberCheck(parsed);
        System.out.println(Utils.sum(parsed));
    }
}

