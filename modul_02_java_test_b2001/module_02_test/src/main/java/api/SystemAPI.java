package api;

import java.util.Scanner;

public class SystemAPI {

    /**
     * @author Jahidul Islam
     * Read System JDK 8 API documantation to be read and System source code to be viewed
     * Demonastrate your understanding on System after reading the documentation
     * Show some uses of System Class
     * Explain, what is System.out.println()?
     * List all the members of the System class, such as class variable, instance variables, local variables
     * method type etc
     *
     * */

    public static void main(String[] args) {

        System.out.println("Hello World");
        for(int i = 0; i < 10; i++) {

            for(int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        Scanner stdin = new Scanner(System.in);
        System.out.println("Enter something on the keyboard");
        String userInput = stdin.nextLine();
        System.out.println("This is what you entered " + userInput );
    }


}
