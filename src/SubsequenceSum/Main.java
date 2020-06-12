package SubsequenceSum;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static final int[] DEFAULT_SET=  {1, -3, 6, -2, 9, -8, -6, 4, 8};//{10, 2, -15, 10, 50, -1, 3, -30, 10};
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args){

        int choice;
        int maxSum = 0;

        do {
            menu();
            choice = in.nextInt();
            in.nextLine();
            switch (choice) {
                case 1:
                    maxSum = customMaxSum(true);
                    System.out.println("[Brute Force] Max sum found = " + maxSum);
                    break;
                case 2:
                    maxSum = customMaxSum(false);
                    System.out.println("[Divide to Conquer] Max sum found = " + maxSum);
                    break;
                case 3:
                    maxSum = MaxSum.divideToConquer(DEFAULT_SET, 0, DEFAULT_SET.length-1);
                    System.out.println("[Brute Force] Max sum found = " + maxSum);
                    maxSum = MaxSum.bruteForce(DEFAULT_SET);
                    System.out.println("[Divide to Conquer] Max sum found = " + maxSum);
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

        return bf ? MaxSum.bruteForce(arr) : MaxSum.divideToConquer(arr, 0, arr.length-1);
    }

    public static void menu(){
        System.out.print("\n1 - Max subsequence sum with custom value (Brute Force)\n2 - Max subsequence sum with custom value (Divide to conquer)" +
                "\n3 - Max subsequency sum in both methods with example value: " + Arrays.toString(DEFAULT_SET) +
                "\n\n0 - END\n\nSelect your option: ");
    }
}
