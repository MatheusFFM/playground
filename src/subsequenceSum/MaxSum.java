package subsequenceSum;

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
        int maxSum = Integer.MIN_VALUE;
        List<Integer> subsequence = new ArrayList<>();

        while (limit <= arr.length) {
            //select the start subsequency point
            for (int i = 0; i < arr.length - limit; i++) {

                int sum = 0;

                //creates the subsequency
                for (int j = i; j < i + limit; j++) {
                    sum = sum + arr[j];
                    subsequence.add(arr[j]);
                }

                //Uncomment this for see all the subsequence generated
                //System.out.println(subsequence  + "\tsum = " + sum + "\twith limit = " + limit);

                //Chose the max value
                maxSum = Math.max(sum, maxSum);

                //reset the subsequency
                subsequence.clear();
            }
            limit++;
        }

        //Case the sum of all vector is higher than a subsequence
        return  Math.max(IntStream.of(arr).sum(), maxSum);
    }

    /***
     *
     * Public call to the function divideToConquer that orders the algorthm to find
     * the max subsequency sum from begin to end of the arr.
     *
     * @param arr the array to find the max subsequency sum
     * @return the max subsequency sum
     */
    public static int divideToConquer(int arr[]){
        return divideToConquer(arr, 0, arr.length-1);
    }

    /***
     * This method find the max subsequency sum calculating the max subsequency sum from the begin
     * to middle, from middle to end and the subsequencies that includes the middle point of the arr.
     * The first two values are found with a recursion that returns the half of array after the middle
     * for the left and the half of array before the middle for the right, and the last condition is found
     * with the function crossing. The max value of the three conditions is the algorithm's result.
     *
     * @param arr the array to find the max subsequency sum
     * @param init the start of the array
     * @param end the end of the array
     * @return the max subsequency sum
     */
    private static int divideToConquer(int arr[], int init,
                              int end)
    {
        // If the arr has only one element, it's the base case were the recursion ends
        if (init == end) {
            return arr[end];
        }

        // The algorithm finds the middle point of arr
        int mid = (init + end)/2;

        /*
        Now the algorithm looks for the max value in 3 cenarious:
            1° -> All the subsequencies in the left side of the arr
            2° -> All the subsequencies in the right side of the arr
            3° -> The subsequencies that cross the middle, so the algorithm does another function
         */
        return Math.max(Math.max(divideToConquer(arr, init, mid),
                divideToConquer(arr, mid+1, end)),
                crossing(arr, init, mid, end));
    }

    /***
     * This finds the max subsequency sum that crosses the arr's middle (mid).
     * By iteration this finds the best value for left (after the middle) and
     * for the right (before the middle) and then, return the max value among
     * the left, the right and the sum of left and right.
     *
     * @param arr the array to find the max subsequency sum
     * @param init the start of the array
     * @param mid the middle point of the array
     * @param end the end of the array
     * @return the max subsequency sum
     */

    private static int crossing(int arr[], int init,
                               int mid, int end){

        int sum = 0;
        int left = Integer.MIN_VALUE;

        //Select the max subsequency among all possibilities in the left side of the array, including the middle
        for (int i = mid; i >= init; i--)
        {
            sum = sum + arr[i];
            left = Math.max(sum, left);
        }

        sum = 0;
        int right = Integer.MIN_VALUE;

        //Select the max subsequency among all possibilities in the right side of the array, including the middle
        for (int i = mid + 1; i <= end; i++)
        {
            sum = sum + arr[i];
            right = Math.max(right, sum);
        }

         /*
        Now the algorithm looks for the max value in 3 possibilities:
            1° -> The max subsequencie in the left side
            2° -> The max subsequencie in the right side
            3° -> The sum of the left an right max subsequencie, this isn't always the max because the
                  subsequency can have negative values
         */
        return Math.max(left + right, Math.max(left, right));
    }
}
