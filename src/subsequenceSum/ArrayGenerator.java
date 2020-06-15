package subsequenceSum;

import java.util.Random;

public class ArrayGenerator {

    private static final int MIN = -100;
    private static final int MAX = 100;

    public static int[] generate(int length){
        int[] arr = new int[length];
        Random random = new Random();
        for(int i = 0; i < length; i++){
            arr[i] = random.nextInt(MAX - MIN) + MIN;
        }
        return arr;
    }
}
