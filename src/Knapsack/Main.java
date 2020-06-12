package Knapsack;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static Item ITEM_1 = new Item(60, 10, "A");
    private static Item ITEM_2 = new Item(140, 20, "B");
    private static Item ITEM_3 = new Item(50, 5, "C");
    private static Item ITEM_4 = new Item(60, 12, "D");
    private static Item[] ITENS = new Item[]{ITEM_1, ITEM_2, ITEM_3, ITEM_4};
    private static int TOTAL_WEIGHT = 30;
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] arg) {

        int choice;

        do {
            int maxValue = 0;
            menu();
            choice = in.nextInt();
            in.nextLine();
            switch (choice) {
                case 1:
                    maxValue = customMaxValue();
                    break;
                case 2:
                    maxValue = Knapsack.dinamicSolution(TOTAL_WEIGHT, ITENS);
                    break;
            }
            System.out.println("\nThe max value you can have is " + maxValue);
        } while (choice != 0);
    }

    public static int customMaxValue(){
        System.out.print("How many itens can you have? ");
        int length = in.nextInt();

        Item[] arr = new Item[length];

        for(int i = 0; i < length; i++){
            System.out.print("\nType the " + (i+1) + "° item's name: ");
            in.nextLine();
            String name = in.nextLine();
            System.out.print("Type the " + (i+1) + "° item's value: ");
            int value = in.nextInt();
            System.out.print("Type the " + (i+1) + "° item's weight: ");
            int weight = in.nextInt();

            Item tmpItem = new Item(value, weight, name);
            arr[i] = tmpItem;
        }

        System.out.print("\nHow much weight can you carry? ");
        int maxWeight = in.nextInt();

        return Knapsack.dinamicSolution(maxWeight, arr);
    }

    public static void menu(){
        System.out.print("\n1 - Create custom itens for the knapsack\n2 - Use the example: " + Arrays.toString(ITENS)
        + "\n\n0 - END\n\nSelect your option: ");
    }


}
