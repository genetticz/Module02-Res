package datastructure;

import java.util.LinkedList;

public class UseArrayList {

	public static void main(String[] args) {

		/**
		 * @author Jahidul Islam
		 * Demonstrate how to use ArrayList that includes add,peek,remove,retrieve elements.
		 * Use For Each loop and while loop with Iterator to retrieve data.
		 * Store all the sorted data into one of the databases.
		 * 
		 */

		LinkedList<Integer> list = new LinkedList<>();

		for(int i = 1; i < 50; i++) {
			if (i % 2 == 0)
				list.add(i);
		}

		list.forEach(x -> System.out.println(x));
		System.out.println("First element in the list is " + list.peekFirst());

	

	}

}
