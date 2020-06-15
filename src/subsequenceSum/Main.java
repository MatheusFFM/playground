package subsequenceSum;

import java.util.Arrays;
import java.util.Scanner;
import chronometer.Chronometer;

/**
 * This shows how the max subsequence sum is much more effective with the divide and conquer
 * method than the brute force method. The divide and conquer is faster, in a 5 seconds reference
 * test, the methods can solve the problem with an array's length:
 *  Brute force: approximately 1600 elements.
 *  Divide to conquer: more than 100.000.000 elements.
 *
 * so the divide to conquer method is extremely effective.
 */
public class Main {

    //Set example
    private static final int[] DEFAULT_SET=  {10, 2, -15, 10, 50, -1, 3, -30, 10};

    //Variáveis de teste
    private static final long MAX_TIME = 5000000000L; // the time reference (5 seconds)
    private static final int INIT_TEST_LENGTH = 0; // the initial test;

    //The array's length limit to print when it's random generated
    private static final int MAX_PRINT_ARRAY = 100;

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
                    maxSum = customMaxSum(true);
                    time = chronometer.stop();
                    System.out.println("[Brute Force] Max sum found = " + maxSum + "\t time = " + time + " nanoseconds"+
                            "\t subsequence = " + MaxSum.getBestSubsequence() );
                    break;
                case 2:
                    //Divide to conquer with custom values
                    maxSum = customMaxSum(false);
                    time = chronometer.stop();
                    System.out.println("[Divide to Conquer] Max sum found = " + maxSum + "\t time = " + time + " nanoseconds"+
                            "\t subsequence = " + MaxSum.getBestSubsequence() );
                    break;
                case 3:
                    //Divide to conquer and brute force methods with a default value
                    chronometer.start();
                    maxSum = MaxSum.divideToConquer(DEFAULT_SET);
                    time = chronometer.restart();
                    System.out.println("[Divide to Conquer] Max sum found = " + maxSum + "\t time = " + time + " nanoseconds" +
                            "\t subsequence = " + MaxSum.getBestSubsequence() );
                    maxSum = MaxSum.bruteForce(DEFAULT_SET);
                    time = chronometer.stop();
                    System.out.println("[Brute Force] Max sum found = " + maxSum + "\t time = " + time +
                            " nanoseconds\t subsequence = " + MaxSum.getBestSubsequence() );
                    break;
                case 4:
                    //Brute force with a random generated array but the user chooses the array's length
                    maxSum = customLength(true);
                    time = chronometer.stop();
                    System.out.println("[Brute Force] Max sum found = " + maxSum + "\t time = " + time + " nanoseconds"+
                            "\t subsequence = " + MaxSum.getBestSubsequence() );
                    break;
                case 5:
                    //Divide to conquer with a random generated array but the user chooses the array's length
                    maxSum = customLength(false);
                    time = chronometer.stop();
                    System.out.println("[Divide to Conquer] Max sum found = " + maxSum + "\t time = " + time + " nanoseconds"+
                            "\t subsequence = " + MaxSum.getBestSubsequence() );
                    break;
            }
        } while (choice != 0);

    }

    /***
     * This method creates a new set based on the length and elements the user wants,
     * then, this calls and return the result of the max subsequence sum with brute force
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

        chronometer.start();
        return bf ? MaxSum.bruteForce(arr) : MaxSum.divideToConquer(arr);
    }

    /***
     * This method creates a new set based on the length the user wants and it's filled with
     * random values, then, this calls and return the result of the max subsequence sum with
     * brute force or divide to conquer
     *
     * @param bf if true, calls brute force method, else, call divider to conquer method
     * @return the result of the selected method
     */
    public static int customLength(boolean bf){
        int[] arr;

        System.out.print("Type your array's length: ");
        int length = in.nextInt();

        arr = ArrayGenerator.generate(length);

        String message = arr.length <= MAX_PRINT_ARRAY ? Arrays.toString(arr) : "Array to large to print";

        System.out.println("Your array = " + message);

        chronometer.start();
        return bf ? MaxSum.bruteForce(arr) : MaxSum.divideToConquer(arr);
    }

    /**
     * This method was used for help to search a big array length that can be solved
     * in less than 5 seconds with brute force and divide to conquer.
     *
     * @param bf if true, calls brute force method, else, call divider to conquer method
     * @return the max value with execution equals or lower than five seconds, if the initial
     * value is already higher than five seconds returns -1
     */
    public static int getMax(boolean bf){
        int length = INIT_TEST_LENGTH;
        boolean low = true;
        int[] arr;

        chronometer.start();
        arr = ArrayGenerator.generate(length);
        int result =  bf?MaxSum.bruteForce(arr) : MaxSum.divideToConquer(arr);
        long time = chronometer.stop();

        while(time <= MAX_TIME) {
            low = false;
            System.out.println("\n\n------\nTrying: " + length);
            arr = ArrayGenerator.generate(length);
            chronometer.start();
            result =  bf?MaxSum.bruteForce(arr) : MaxSum.divideToConquer(arr);
            time = chronometer.stop();
            System.out.println("Time = " + time);
            length++;
        }
        return low?-1: length;
    }

    /**
     * Prints menu on console
     */
    public static void menu(){
        System.out.print("\n1 - Max subsequence sum with custom value (Brute Force)\n2 - Max subsequence sum with custom value (Divide to conquer)" +
                "\n3 - Max subsequence sum in both methods with example value: " + Arrays.toString(DEFAULT_SET) +
                "\n4 - Random array with custom length (Brute Force)" +
                "\n5 - Random array with custom length (Divide to conquer)\n\n0 - END\n\nSelect your option: ");
    }
}
