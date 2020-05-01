package io_problems;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DataReader {

	private static FileReader fr;

	public static void main(String[] args) throws IOException {

		/**
		 * Use API to read the below textFile and print to console.
		 * /src/main/resources/Key-To-Success
		 * Use FileReader class, no need to store in buffer
		 * Use try....catch block to handle Exception.
		 * Use ForEach loop/while loop/Iterator to retrieve data.
		 */

		try{
			fr = new FileReader(System.getProperty("user.dir") +"/modul_02_java_test_b2001/module_02_test/src/main/resources/Key-To-Success");
			int lineNum;
			String formedString = "";
			while((lineNum = fr.read()) != -1){
//				System.out.print((char)lineNum);
				formedString+= Character.toString((char) lineNum);
			}
			System.out.println(formedString);
		} catch(FileNotFoundException fileNotFoundException){
			System.out.println(fileNotFoundException.getMessage());
		}
		catch(IOException ioException) {
			System.out.println(ioException.getMessage());
		}
		finally {
			fr.close();
		}

	}

}
