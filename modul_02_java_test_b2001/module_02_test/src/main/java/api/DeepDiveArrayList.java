package api;

import java.util.ArrayList;
import java.util.List;

public class DeepDiveArrayList {

    /**
     * @author Jahiudl Islam
     * ArrayList JDK 8 API documantation to be read and ArrayList source code to be viewed
     * Demonastrate your understanding on ArrayList after reading the document
     * You are free to document your understanding using comment
     *
     * */

    public static void main(String[] args) {

        arrDemo().forEach(x -> {
            System.out.println(x);
        });
    }

    public static List<Integer> arrDemo() {

        List<Integer> arr = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            arr.add(i);
        }
        return arr;
    }
}
