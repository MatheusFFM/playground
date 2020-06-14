package subsequenceSum;

import java.util.Arrays;
import java.util.Scanner;
import chronometer.Chronometer;

public class Main {

    //Set example
    private static final int[] DEFAULT_SET=  {10, 2, -15, 10, 50, -1, 3, -30, 10};

    private static Scanner in = new Scanner(System.in);
    private static Chronometer chronometer = new Chronometer();

    public static void main(String[] args){

        int choice;
        long time;

        do {
            int maxSum = 0;
            menu();
            choice = in.nextInt();
            in.nextLine();
            switch (choice) {
                case 1:
                    //Brute force with custom values
                    chronometer.start();
                    maxSum = customMaxSum(true);
                    time = chronometer.stop();
                    System.out.println("[Brute Force] Max sum found = " + maxSum + "\t time = " + time + " nanoseconds");
                    break;
                case 2:
                    //Divide to conquer with custom values
                    chronometer.start();
                    maxSum = customMaxSum(false);
                    time = chronometer.stop();
                    System.out.println("[Divide to Conquer] Max sum found = " + maxSum + "\t time = " + time + " nanoseconds");
                    break;
                case 3:
                    //Divide to conquer and brute force methods with a default value
                    chronometer.start();
                    maxSum = MaxSum.divideToConquer(DEFAULT_SET);
                    time = chronometer.restart();
                    System.out.println("[Divide to Conquer] Max sum found = " + maxSum + "\t time = " + time + " nanoseconds");
                    maxSum = MaxSum.bruteForce(DEFAULT_SET);
                    time = chronometer.stop();
                    System.out.println("[Brute Force] Max sum found = " + maxSum + "\t time = " + time + " nanoseconds");
                    break;
            }
        } while (choice != 0);

    }

    /***
     * This method creates a new set based on the length and elements the user wants,
     * then, this calls and return the result of the max subsequency sum with brute force
     * or divide to conquer
     *
     * @param bf if true, calls brute force method, else, call divider to conquer method
     * @return the result of the selected method
     */
    public static int customMaxSum(boolean bf){
        int[] arr;

        System.out.print("Type your array's length: ");
        int length = in.nextInt();

        arr = new int[length];

        for(int i = 0; i < length; i++){
            System.out.print("Type your value for position [" + i + "]: ");
            arr[i] = in.nextInt();
        }

        System.out.println("Your array = " + Arrays.toString(arr));

        return bf ? MaxSum.bruteForce(arr) : MaxSum.divideToConquer(arr);
    }

    /**
     * Prints menu on console
     */
    public static void menu(){
        System.out.print("\n1 - Max subsequence sum with custom value (Brute Force)\n2 - Max subsequence sum with custom value (Divide to conquer)" +
                "\n3 - Max subsequency sum in both methods with example value: " + Arrays.toString(DEFAULT_SET) +
                "\n\n0 - END\n\nSelect your option: ");
    }
}
