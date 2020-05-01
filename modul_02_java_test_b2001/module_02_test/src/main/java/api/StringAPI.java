package api;

public class StringAPI {

    /**
     * @author Jahiudl Islam
     * Read String JDK 8 API documantation to be read and String source code to be viewed
     * Demonastrate your understanding on String after reading the documentation
     * You are free to document your understanding using comment
     * Reason to comment is to keep documentation so that next developer can get highlevel understaning of your implementation
     * by reading your comments/documents
     *
     * */

    public static void main(String[] args) {

        String testString = "";
        testString+= "Hello World!";
        testString = testString.substring(testString.indexOf(" ")+1);
        testString = testString.split("!")[0];
        StringBuilder newStr = new StringBuilder(testString);
        newStr.insert(0,"The ");
        System.out.print(newStr + " ");

        System.out.print(testString);
    }
}
