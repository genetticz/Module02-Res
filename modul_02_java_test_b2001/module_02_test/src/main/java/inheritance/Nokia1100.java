package inheritance;

public class Nokia1100  extends PreNokia1100 {

   PreNokia1100 p100;
   /**
    * Make necessary changes to inherit PreNokia1100
    * Declare and assign value to a String instance variable called nameOfTheClass
    * Implement a method to add photo gallery photoGallery()
    * Create default constructor and a parameterized constructor with int x parameter
    */


   public void display() {
      System.out.println("the sky is big and blue");
      p100.sendText();
   }


   public void makeCall() {
      System.out.println("dialing number now");
   }
}
