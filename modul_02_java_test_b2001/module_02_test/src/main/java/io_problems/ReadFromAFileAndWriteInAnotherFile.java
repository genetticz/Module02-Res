package io_problems;

import java.io.*;

public class ReadFromAFileAndWriteInAnotherFile {

    /***
     * Read form a file XXXXXX write in a file YYYYYY
     *
     * */

    private static FileReader fr;

    public static void main(String[] args) throws IOException {
        ReadFromAFileAndWriteInAnotherFile rf = new ReadFromAFileAndWriteInAnotherFile();
        PrintWriter pw = new PrintWriter(new File(System.getProperty("user.dir") +"/modul_02_java_test_b2001/module_02_test/src/main/resources/Copied-Key-To-Success"));
        String sendToPw = rf.readThisFile();
        pw.println(sendToPw);
        pw.close();
        System.out.println("Finished writing to new file");
    }

    public String readThisFile() throws IOException {
        String formedString = "";
        try{
            fr = new FileReader(System.getProperty("user.dir") +"/modul_02_java_test_b2001/module_02_test/src/main/resources/Key-To-Success");
            int lineNum;
            while((lineNum = fr.read()) != -1){
//				System.out.print((char)lineNum);
                formedString+= Character.toString((char) lineNum);
            }
        } catch(FileNotFoundException fileNotFoundException){
            System.out.println(fileNotFoundException.getMessage());
        }
        catch(IOException ioException) {
            System.out.println(ioException.getMessage());
        }
        finally {
            fr.close();
        }
        return formedString;
    }
}
