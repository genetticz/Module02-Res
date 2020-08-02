package problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindDuplicates {

    /**
     * Write Code To Filter Duplicate Elements From An Array?
     * */


    public static void main(String[] args) {

        Integer[] ab = {1,2,3,4,5,6};
        Integer[] ac = {1,2,3,4,6};

        HashSet<Integer> aSet = new HashSet<>(Arrays.asList(ab));
        HashSet<Integer> bSet = new HashSet<>(Arrays.asList(ac));

        aSet.retainAll(bSet);

        System.out.println(aSet);


    }

   /* public static boolean arrayContains(int[] array, int element) {
        return Arrays.stream(array)
                .anyMatch(e -> e == element);
    }*/
}