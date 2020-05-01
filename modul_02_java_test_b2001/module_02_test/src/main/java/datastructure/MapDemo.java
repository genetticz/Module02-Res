package datastructure;

import db.DbConnection;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapDemo {

    /**
     * @author Jahidul Islam
     * Create a Map reference variable and store information as you like
     * Show me all possible retrieval process
     * Store map in DB
     *
     * */
    private static Map<String,Integer> mapped;

    public static void main(String[] args) throws SQLException {

        fillMap();
        DbConnection.insertDataFromArrayListToPsql(mapped,"city_population","cityname","population");

    }

    public static void fillMap(){

        mapped = new LinkedHashMap<String, Integer>();
        mapped.put("Jerome",455);
        mapped.put("Vernon",209);
        mapped.put("Bonanza", 1);
        mapped.put("Union",843);
    }
}
