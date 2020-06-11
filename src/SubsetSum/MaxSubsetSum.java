package SubsetSum;

import java.util.ArrayList;
import java.util.List;

public class MaxSubsetSum {

    /***
     *
     * This function creates all subsets of the arr[] param, with three loops:
     * one to measure the length of the subset (limit variable), another to create
     * a subset with each value on array and the last one to make all possible combinations.
     *
     * @param arr is the array to create the subsets
     * @return the max subset sum found
     */
    public static int bruteForce(int arr[]) {

        int limit = 1;
        int maxSum = 0;
        List<Integer> subset = new ArrayList<>();

        while (limit < arr.length) {
            for (int i = 0; i < arr.length - limit; i++) {

                int sum = 0;

                for (int j = i; j < i + limit; j++) {
                    sum = sum + arr[j];
                    subset.add(arr[j]);
                }

                //Uncomment this for see all the subsets generated
                //System.out.println(subset + "\tsum = " + sum + "\twith limit = " + limit);

                maxSum = Math.max(sum, maxSum);

                subset.clear();
            }
            limit++;
        }

        return maxSum;
    }
}
