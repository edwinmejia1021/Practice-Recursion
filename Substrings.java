import structure5.*;

public class Recursion {

  /*
  * Print all substrings of `str`.  (Order does not matter.)
  *
  * pre: Takes a string "str" and runs it through subSetHelper
  * post: prints out the subsets
  */
  public static void substrings(String str) {
    substringHelper(str, "");
  }

  /*
  * Helper method for substrings(String str)
  * `soFar` keeps track of the characters currently in the substring
  *   being built
  *
  * pre: Takes a string to keep track of subsets
  * post: keeps track of subsets containing letter at first index of array and runs again for substring of 2nd letter onwards
  *
  */
  public static void substringHelper(String str, String soFar) {
    //If string is empty, return "" subset with every other subset found
    if (str.equals("") || str.isEmpty()) {
      System.out.println("{\"\"} " + soFar);
    } else {
      //Return all subsets countaining character at index i, and characters that follow it
      for (int i = 1; i <= str.length(); i++){
        for (int n = i+1; n <= str.length(); n++){
          soFar = soFar + " {" + str.substring(0, 1) + str.substring(i, n) + "} ";
        }
      }
      //Run again with character at next index
      soFar = " {" + str.substring(0, 1) + "} " + soFar;
      String newString = str.substring(1, str.length());
      substringHelper(newString, soFar);
    }
  }


  /*
  * Add testing code 
  */
  public static void main(String args[]) {

    System.out.println("\n substring:" );
    substrings("abc");
    System.out.println();
    substrings("CSCI136");
    System.out.println();
    substrings("a");
    System.out.println();
    substrings("");
    System.out.println();

  }
}
