package textSearch;

import java.util.Scanner;

public class Main {
    private static Scanner in = new Scanner(System.in);
    private static final String DEFAULT_TEXT = "This is an example text";
    private static final String DEFAULT_PATTERN = "example";

    public static void main(String[] args) {
        int choice;
        do {
            menu();
            choice = in.nextInt();
            in.nextLine();
            switch (choice) {
                case 1:
                    bfMethod();
                    break;
                case 2:
                    bmhsMethod();
                    break;
                case 3:
                    defaultMethod();
                    break;
            }
        } while (choice != 0);
    }

    private static void defaultMethod() {
        int result = Search.bruteForce(DEFAULT_TEXT, DEFAULT_PATTERN);
        printResult(DEFAULT_PATTERN, result, Search.getExecutionTimes(), "Brute Force");
        result = Search.bmhs(DEFAULT_TEXT, DEFAULT_PATTERN);
        printResult(DEFAULT_PATTERN, result, Search.getExecutionTimes(), "BMHS");
    }

    private static void bfMethod() {
        String[] params = askParams();
        int result = Search.bruteForce(params[0], params[1]);
        printResult(params[1], result, Search.getExecutionTimes(), "Brute Force");
    }

    private static void bmhsMethod() {
        String[] params = askParams();
        int result = Search.bmhs(params[0], params[1]);
        printResult(params[1], result, Search.getExecutionTimes(), "BMHS");
    }

    private static String[] askParams() {
        String[] answer = new String[2];
        answer[0] = ask("Write your text: ");
        answer[1] = ask("Write your pattern: ");
        return answer;
    }

    private static String ask(String question) {
        System.out.print(question);
        return in.nextLine();
    }

    private static void printResult(String pattern, int result, int tries, String method) {
        System.out.println("Your pattern \"" + pattern + "\" is on the position [" + result + "] and was found with " +
                tries + " tries. (" + method + ") ");
    }

    private static void menu() {
        System.out.print("\n1 - Brute Force\n2 - BMHS\n3 - The two methods with default values\n\n0 - END\n\nSelect your option: ");
    }
}
