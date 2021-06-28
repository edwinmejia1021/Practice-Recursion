import structure5.*;

public class Recursion {

  /*
  * Return true if `str` is a string of matched parens,
  * brackets, and braces.
  *
  * pre: Takes in a string of bracketing operators to check if there is a balance of them
  * post: Tries to find pair of bracketing operators and runs again for string with pair removed
  */
  public static boolean isBalanced(String str) {

    //If string is odd, then it will not be balanced
    if(str.length() % 2 == 0){
      //All pairs have been found, end recursion
      if (str.length() == 0) {
        return true;
      } else {
        //If pair isn't found, return false
        int index = giveIndex(str);
        if (index == -1) {
          return false;
        } else {
          //If pair found, run again with pair removed
          return isBalanced(str.substring(0, index) + str.substring(index + 2));
        }
    }
  } else {
      return false;
    }
  }

  //Helper method to look for pairs, return index of found pair or -1 if none found
  public static int giveIndex (String str) {
    int character = str.indexOf("()");
    if (character == -1) {
      character = str.indexOf("[]");
       if (character == -1) {
        character = str.indexOf("{}");
        if (character == -1) {
          return -1;
        }
      }
    }
      return character;
  }


  /*
  * Add testing code 
  */
  public static void main(String args[]) {

    System.out.println("\n isBalanced:" );
    System.out.println(isBalanced("[{[()()]}]"));
    System.out.println(isBalanced("[{[()()]}][{[()()]}]"));
    System.out.println(isBalanced("[{[()()]}{]{[()()]}]"));

  }
}
