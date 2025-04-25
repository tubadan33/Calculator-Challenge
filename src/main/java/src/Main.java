package src;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            try {
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();

                List<Integer> parsed = Utils.parseInput(input);
                Utils.negativeNumberCheck(parsed);
                int sum = Utils.sum(parsed);
                Utils.printFormula(parsed, sum);
                System.out.println(sum);
            } catch (Exception e) {
                running = false;
            }
        }
    }
}

