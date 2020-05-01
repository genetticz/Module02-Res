package api;

import java.util.HashMap;
import java.util.Map;

public class MapAPI {
    /**
     * @author Jahiudl Islam
     * Read Map and HashMap JDK 8 API documantation to be read and Map and HashMap source code to be viewed
     * Demonastrate your understanding on Map and HashMap after reading the documentation
     * You are free to document your understanding using comment
     * Reason to comment is to keep documentation so that next developer can get highlevel understaning of your implementation
     * by reading your comments/documents
     *
     * */

    public static void main(String[] args) {

        Map<Integer,String> mapDem = new HashMap<>();
        mapDem.put(1,"Hi");
        mapDem.put(2,"have");
        mapDem.put(3,"a");
        mapDem.put(4,"good");
        mapDem.put(5,"day");

        for(Map.Entry<Integer,String> dem: mapDem.entrySet()){

            System.out.println(" '"+dem.getKey()+"' " + " this is key");
            System.out.println(" '"+dem.getValue()+"' " + " this is value");
        }
    }
}
