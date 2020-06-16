package subsequenceSum;

public class MaxSum {

    /**
     * This function creates all subsets of the arr[] param with two loops,
     * one to create a subsequence with each value on array and the last one
     * to make all possible combinations.
     *
     * @param arr is the array to create the subsequences
     * @return the max subsequence sum found
     */
    public static int bruteForce(int[] arr) {

        int maxSum = Integer.MIN_VALUE;

            /*
                [-3, 5, 6, 7, -10]

                [-3]
                [-3, 5]
                ...
                [-3, 5, 6, 7, -10]
                END

                [5]
                [5,6]
                ...
                [5, 6, 7, -10]

             */

            //choose an initial element
            for (int i = 0; i < arr.length; i++) {

                int sum = 0;

                //creates the subsequence
                for (int j = i; j < arr.length; j++) {
                    sum += arr[j];
                    maxSum = Math.max(sum, maxSum);
                }
            }

        //Case the sum of all vector is higher than a subsequence
        return  maxSum;
    }

    /***
     *
     * Public call to the function divideToConquer that orders the algorithm to find
     * the max subsequence sum from begin to end of the arr.
     *
     * @param arr the array to find the max subsequence sum
     * @return the max subsequence sum
     */
    public static int divideToConquer(int[] arr){
        return divideToConquer(arr, 0, arr.length-1);
    }

    /***
     * This method find the max subsequence sum calculating the max subsequence sum from the begin
     * to middle, from middle to end and the subsequences that includes the middle point of the arr.
     * The first two values are found with a recursion that returns the half of array after the middle
     * for the left and the half of array before the middle for the right, and the last condition is found
     * with the function crossing. The max value of the three conditions is the algorithm's result.
     *
     * @param arr the array to find the max subsequence sum
     * @param init the start of the array
     * @param end the end of the array
     * @return the max subsequence sum
     */
    private static int divideToConquer(int[] arr, int init,
                              int end)
    {
        // If the arr has only one element, it's the base case were the recursion ends
        if (init == end) {
            return arr[end];
        }

        // The algorithm finds the middle point of arr
        int mid = (init + end)/2;

        /*
        Now the algorithm looks for the max value in 3 canaries:
            1° -> All the subsequences in the left side of the arr
            2° -> All the subsequences in the right side of the arr
            3° -> The subsequences that cross the middle, so the algorithm does another function
         */

        return Math.max(Math.max(divideToConquer(arr, init, mid),
                divideToConquer(arr, mid+1, end)),
                crossing(arr, init, mid, end));
    }

    /***
     * This finds the max subsequence sum that crosses the arr's middle (mid).
     * By iteration this finds the best value for left (after the middle) and
     * for the right (before the middle) and then, return the max value among
     * the left, the right and the sum of left and right.
     *
     * @param arr the array to find the max subsequence sum
     * @param init the start of the array
     * @param mid the middle point of the array
     * @param end the end of the array
     * @return the max subsequence sum
     */

    private static int crossing(int[] arr, int init,
                               int mid, int end){

        int sum = 0;
        int left = Integer.MIN_VALUE;

        //Select the max subsequence among all possibilities in the left side of the array, including the middle
        for (int i = mid; i >= init; i--)
        {
            sum += arr[i];
            left = Math.max(sum, left);
        }

        sum = 0;
        int right = Integer.MIN_VALUE;

        //Select the max subsequence among all possibilities in the right side of the array, including the middle
        for (int i = mid + 1; i <= end; i++)
        {
            sum += arr[i];
            right = Math.max(right, sum);
        }

         /*
        Now the algorithm looks for the max value in 3 possibilities:
            1° -> The max subsequence in the left side
            2° -> The max subsequence in the right side
            3° -> The sum of the left an right max subsequence, this isn't always the max because the
                  subsequence can have negative values
         */
        return Math.max(left + right, Math.max(left, right));
    }
}
