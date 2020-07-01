package collections;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        /* Can't update elements
        *  Add in the last position
        *  Remove the first position
        */

        Queue<String> bank = new LinkedList<>();

        bank.add("Matheus");
        bank.add("Hellen");
        bank.add("Ana");
        bank.add("Daniel");
        bank.add("Luiza");

        System.out.println(bank);

        //remove the first element
        String nextClient = bank.poll();
        System.out.println(nextClient);
        System.out.println(bank);

        //get the first element
        nextClient = bank.peek();
        //bank.element() also gets the first element but can also return an error
        System.out.println(nextClient);
        System.out.println(bank);

    }
}
