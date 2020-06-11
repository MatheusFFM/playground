package SubsetSum;

public class Main {

    private static final int[] DEFAULT_SET= {10, 2, -15, 10, 50, -1, 3, -30, 10};

    public static void main(String[] args){

        //Calls the brute force method
        int maxSum = MaxSubsetSum.bruteForce(DEFAULT_SET);

        System.out.println(maxSum);
    }
}
