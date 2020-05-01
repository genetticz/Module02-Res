package datastructure;

import utility.XLSXFileReader;

public class TwoDimensionalArrayDemo {

    /**
     * @author Jahidul Islam
     * Construct Two Dimensional array reference variable and
     * store all the data of testData.xlsx from data directory
     * You do not have to read xlsx file only the similar data need to be
     * stored in 2D Array reference variable
     * Later get those value by index and also by using any iteration process
     *
     *  */

    public static void main(String[] args) throws Exception {

        XLSXFileReader x1 = new XLSXFileReader(System.getProperty("user.dir") + "/modul_02_java_test_b2001/module_02_test/data/testData.xlsx");
        String[][] excelBook = x1.getExcelSheetData("Sheet1");

        for(int row = 0; row < excelBook.length; row++) {
            for(int col = 0; col < excelBook[row].length; col++) {
                System.out.println(excelBook[row][col]);
            }
        }
    }
}
