package SubsequenceSum;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class MaxSum {

    /***
     *
     * This function creates all subsets of the arr[] param, with three loops:
     * one to measure the length of the subsequence  (limit variable), another to create
     * a subsequence with each value on array and the last one to make all possible combinations.
     *
     * @param arr is the array to create the subsequences
     * @return the max subsequence sum found
     */
    public static int bruteForce(int arr[]) {

        int limit = 1;
        int maxSum = 0;
        List<Integer> subsequence = new ArrayList<>();

        while (limit <= arr.length) {
            for (int i = 0; i < arr.length - limit; i++) {

                int sum = 0;

                for (int j = i; j < i + limit; j++) {
                    sum = sum + arr[j];
                    subsequence.add(arr[j]);
                }

                //Uncomment this for see all the subsequence generated
                //System.out.println(subsequence  + "\tsum = " + sum + "\twith limit = " + limit);

                maxSum = Math.max(sum, maxSum);

                subsequence.clear();
            }
            limit++;
        }

        //Case the sum of all vector is higher than a subsequence
        maxSum = Math.max(IntStream.of(arr).sum(), maxSum);

        return maxSum;
    }

    public static int divideToConquer(int arr[], int l,
                                      int h)
    {
        return 0;
    }


}
