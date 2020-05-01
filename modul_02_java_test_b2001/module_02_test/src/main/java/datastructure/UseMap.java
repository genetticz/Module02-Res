package datastructure;

import db.DbConnection;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class UseMap {

	public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
		/**
		 * @author Jahidul Islam
		 * Demonstrate how to use Map that includes storing and retrieving elements.
		 * Add List<String> into a Map. Like, Map<String, List<string>> list = new HashMap<String, List<String>>();
		 * Use For Each loop and while loop with Iterator to retrieve data.
		 * You can use any other retrieval process
		 * Use any databases[ MySql] to store data and retrieve data.
		 */

		List<String> list = DbConnection.readDatabase("hashset_demo","countries");



		LinkedHashMap<String,List> mapped = new LinkedHashMap<>();
		mapped.put("ListOfCountries",list);

		for(Map.Entry<String, List> st: mapped.entrySet()) {
			System.out.println(st.getKey() + " " + st.getValue());
		}
	}

}
