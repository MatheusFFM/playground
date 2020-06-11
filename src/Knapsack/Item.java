package Knapsack;

public class Item {
    private int value;
    private int weight;
    private String name;

    public Item(int value, int weight, String name) {
        this.value = value;
        this.weight = weight;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }
}
