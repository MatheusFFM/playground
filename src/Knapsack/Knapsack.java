package Knapsack;

public class Knapsack {

    static int dinamicSolution(int capacity, Item[] items) {
        {
            int[][] table = new int[items.length + 1][capacity + 1];

            for (int i = 1; i <= items.length; i++) {
                for (int j = 1; j <= capacity; j++) {
                    if (items[i - 1].getWeight() <= j)
                        table[i][j] = Math.max(
                                items[i - 1].getValue() + table[i - 1][j - items[i - 1].getWeight()],
                                table[i - 1][j]);
                    else
                        table[i][j] = table[i - 1][j];
                }
            }

            return table[items.length][capacity];
        }
    }
}
