package Knapsack;

public class Knapsack {

    /***
     *
     * This makes a table and fill it with the best possible value considering
     * the index of the row and collumns a reference, the last position
     * recieve the higher value possible and represents all itens possibilities
     * and all the knapsack capacity.
     *
     * @param capacity is the max weight you can carry
     * @param items is an Item array with all the possibles itens
     * @return the max value you can carry
     */

    static int dinamicSolution(int capacity, Item[] items) {
        {
            int[][] table = new int[items.length + 1][capacity + 1];

            for (int i = 1; i <= items.length; i++) {
                for (int j = 1; j <= capacity; j++) {
                    if (items[i - 1].getWeight() <= j)
                        //This operation is used because a old combination value can be higher than the new one value discovered
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
