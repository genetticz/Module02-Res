package datastructure;

import db.DbConnection;

import java.sql.SQLException;
import java.util.HashSet;

public class HashSetDemo {

    /**
     * @author Jahidul Islam
     * Create HashSet and store data
     * Get the data from HashSet and print
     * Get the data from HashSet and insert it in db table
     *
     * */
    private static HashSet<String> hashDemo;

    public static void main(String[] args) throws SQLException {

        // fill up our hash set that only accepts unique values
        fillHashSet();
        DbConnection.insertDataFromArrayListToPsql(hashDemo,"hashset_demo","countries");
    }

    public static void fillHashSet(){

        hashDemo = new HashSet<String>();
        hashDemo.add("United States");
        hashDemo.add("Canada");
        hashDemo.add("Mexico");
        hashDemo.add("Cuba");
        hashDemo.add("Jamaica");
        hashDemo.add("Bahamas");
        hashDemo.add("Haiti");
        hashDemo.add("Guyana");
        hashDemo.add("Bahamas");
    }
}
