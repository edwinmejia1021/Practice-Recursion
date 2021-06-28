import structure5.*;

public class Recursion {

  /*
  * Print `number` in binary
  *
  * pre: Takes a number that will be printed out in binary
  * post: Returns last binary digit depending on mod, then runs again for remaining integer (divided by 2)
  */
  public static void printInBinary(int number) {
    if (number >= 1) {
      //Stop recursion when number = 2 or higher
      if (number > 1) {
        printInBinary((number -(number % 2))/ 2);
        System.out.println(number % 2);
    } else {
        System.out.println(number % 2);
      }
    }  else {
      System.out.println(number);
    }
  }

  /*
  * Add testing code 
  */
  public static void main(String args[]) {

    System.out.println("\n printInBinary:" );
    printInBinary(0);
    System.out.println();
    printInBinary(30);
    System.out.println();
    printInBinary(1);
    System.out.println();
    printInBinary(110);
    System.out.println();
    printInBinary(2048);
    System.out.println();
    printInBinary(43);
    System.out.println();

  }
}
