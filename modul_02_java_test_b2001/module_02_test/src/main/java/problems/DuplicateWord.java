package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mrahman on 04/22/17.
 */

public class DuplicateWord {

    private static ArrayList<String> storage;

    public static void main(String[] args) {
        /*
         * Write a java program to find the duplicate words and their number of occurrences in the string.
         * Also Find the average length of the words.
         */

        String st = "Java is a programming Language. Java is also an Island of Indonesia. Java is widely used language";
        System.out.println(findDup(st));
    }

    public static Map<String,Integer> findDup(String words) {

        storage = new ArrayList<>();
        Map<String,Integer> mapped = new HashMap<>();
        ArrayList<String> arr = new ArrayList<>(Arrays.asList(words.replace(".","").split(" ")));

        for(int i = 0; i < arr.size(); i++) {

            if (storage.contains(arr.get(i))) {
                System.out.println("found existing word: " + arr.get(i));
                mapped.put(arr.get(i),mapped.get(arr.get(i)) + 1);
            }
            else{
                storage.add(arr.get(i));
                mapped.put(arr.get(i),1);
            }
        }
        return mapped;
    }

}
