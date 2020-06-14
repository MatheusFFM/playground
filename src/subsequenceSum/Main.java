package subsequenceSum;

import java.util.Arrays;
import java.util.Scanner;
import chronometer.Chronometer;

public class Main {

    private static final int[] DEFAULT_SET=  {1, -3, 6, -2, 9, -8, -6, 4, 8};//{10, 2, -15, 10, 50, -1, 3, -30, 10};
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
                    chronometer.start();
                    maxSum = customMaxSum(true);
                    time = chronometer.stop();
                    System.out.println("[Brute Force] Max sum found = " + maxSum + "\t time = " + time + " nanoseconds");
                    break;
                case 2:
                    chronometer.start();
                    maxSum = customMaxSum(false);
                    time = chronometer.stop();
                    System.out.println("[Divide to Conquer] Max sum found = " + maxSum + "\t time = " + time + " nanoseconds");
                    break;
                case 3:
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

    public static void menu(){
        System.out.print("\n1 - Max subsequence sum with custom value (Brute Force)\n2 - Max subsequence sum with custom value (Divide to conquer)" +
                "\n3 - Max subsequency sum in both methods with example value: " + Arrays.toString(DEFAULT_SET) +
                "\n\n0 - END\n\nSelect your option: ");
    }
}
