package datastructure;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map;

public class HashTable {

    /**
     * SHow your understanding on HashTable
     * Use some methods from HashTable Class
     * */

    public static void main(String[] args) {

        Hashtable<Integer, String> h = new Hashtable<Integer, String>();
        h.put(1,"United States");
        h.put(2, "Canaada");
        h.put(3,"Puerto Rico");
        h.put(4,"Brazil");

        System.out.println("The hash code is " + h.hashCode());

        Enumeration e1 = h.keys();
        System.out.println("display key:");

        while (e1.hasMoreElements()) {
            System.out.println(e1.nextElement());
        }

        for(Map.Entry<Integer,String> ar: h.entrySet()){
            System.out.println(ar.getKey() + " " + ar.getValue());
        }


    }
}
