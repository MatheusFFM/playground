package Knapsack;

public class Main {
    public static void main(String[] arg) {
        Item[] itens = new Item[]{};
        int totalWeight = 50;
        System.out.println(Knapsack.dinamicSolution(totalWeight, itens));
    }
}
