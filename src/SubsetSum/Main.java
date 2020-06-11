package SubsetSum;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static final int[] DEFAULT_SET= {10, 2, -15, 10, 50, -1, 3, -30, 10};
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
                    maxSum = customMaxSum();
                    break;
                case 2:
                    maxSum = MaxSubsetSum.bruteForce(DEFAULT_SET);
                    break;
            }
            System.out.println("Max sum found = " + maxSum);
        } while (choice != 0);

    }

    public static int customMaxSum(){
        int length = 0;
        int[] arr;

        System.out.print("Type your array's length: ");
        length = in.nextInt();

        arr = new int[length];

        for(int i = 0; i < length; i++){
            System.out.print("Type your value for position [" + i + "]: ");
            arr[i] = in.nextInt();
        }

        System.out.println("Your array = " + Arrays.toString(arr));

        return MaxSubsetSum.bruteForce(arr);
    }

    public static void menu(){
        System.out.print("\n1 - Max subset sum with custom value\n2 - Max subset sum with example value: " + Arrays.toString(DEFAULT_SET) +
                "\n\n0 - END\n\nSelect your option: ");
    }
}
