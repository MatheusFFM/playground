package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ArrayListExample {
    public static void main(String[] args) {

        List<String> people = new ArrayList<>();

        //add a new element to the list
        people.add("Matheus");
        people.add("Hellen");
        people.add("Isabela");
        people.add("Ana");
        people.add("Leonardo");
        people.add("Marcela");
        people.add("Julio");
        System.out.println("ADDS: " + people);

        //sort the list alphabetically
        Collections.sort(people);
        System.out.println("SORT: " + people);

        //update an element in a chosen position
        people.set(3, "Julia");
        System.out.println("SET: " + people);

        //remove an element by position or by an Object
        people.remove(4);
        people.remove("Marcela");
        System.out.println("REMOVE: " + people);

        //return an element in a chosen position
        String person = people.get(1);
        System.out.println("GET: " + person);

        //return the position of a chosen element
        int index = people.indexOf("Isabela");
        System.out.println("INDEX OF: " + index);

        //return the list length
        int size = people.size();
        System.out.println("SIZE: " + size);

        //return if the list contains the element
        System.out.println("CONTAINS: " + people.contains("Matheus"));

        //iterate in all elements with for loop
        System.out.print("For Each: ");
        for (String element : people){
            System.out.print(element + ", ");
        }
        System.out.println();

        //iterate in all elements with iterator
        Iterator<String> iterator = people.iterator();
        System.out.print("Iterator: ");
        while (iterator.hasNext()){
            System.out.print(iterator.next() + ", ");
        }
        System.out.println();

        //return if the list is empty
        System.out.println("IS EMPTY: " + people.isEmpty());

        //empty the list
        people.clear();
        System.out.println("CLEAR : " + people);
    }
}
