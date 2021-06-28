import structure5.*;

public class Recursion {

  /*
  * Return number of cannoballs in pyramid with the given `height`.
  * pre: Takes in a pyramid height and work backwards
  * post: Squares the height and then adds it to sum of the pyramid. Does this until input height is 0 and returns total number of cannonballs
  */
  public static int countCannonballs(int height) {
    if (height == 0){
      return 0;
    } else {
      //Adds height^2 to number of cannonballs in past pyramid
      int i = height * height;
      return countCannonballs(height - 1) + i;
    }
  }


  /*
  * Return true if `str` is a palindrome.
  * pre: Takes a string to check if it is palindrome
  * post: If the first and last characters of input string are equal, method will run again for new substring until it is proven to be Palindrome or not
  */
  public static boolean isPalindrome(String str) {
    char first = str.charAt(0);
    char end = str.charAt(str.length() - 1);

    if(first == end){
      //if first and last are same, only one character will be left, so it is palindrome
      if(str.length () == 3){
        return true;
      } else{
        //recursive call of new substring between first and last
      return isPalindrome(shortString(str));
    }
    } else{
      return false;
    }
  }

  //Return string between first and last characters of input string
  public static String shortString(String str){
    String shortened = str.substring( 1, str.length()-1);
    return shortened;
  }

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
  * Return whether a subset of the numbers in nums add up to sum,
  * and print them out.
  *
  * pre: takes an input for an array of numbers and the target sum of numbers you want a subset to add up to
  * post: will return true or false for whether a subset of the numbers add up to
  * the target sum and will display one of those subsets
  */
  public static boolean printSubSetSum(int nums[], int targetSum) {
    return subSetHelper(nums, targetSum, 0);
  }

  //Returns subset of numbers that add up to targetSum or none if false
  public static boolean subSetHelper(int numsSet[], int target, int index){
    if(numsSet.length == index){
      return target == 0;
    } else {
    if(subSetHelper(numsSet, target - numsSet[index], index + 1)){
      System.out.println(numsSet[index]);
      return true;
    }
  }

  return subSetHelper(numsSet, target, index + 1);

  }


  /*
  * Return the number of different ways elements in nums can be
  * added together to equal sum (you do not need to print them all).
  *
  * pre: takes an input for an array of numbers and the target sum of numbers you want a subset to add up to
  * post: will return true or false for whether a subset of the numbers add up to
  * the target sum and will display the total number of subsets that make it possible
  *
  */
  public static int countSubSetSumSolutions(int nums[], int targetSum) {
    return countSubSetHelper(nums, targetSum, 0);
  }

  // Keeps track of subsets that add up targetSum, if any
  public static int countSubSetHelper(int numsSet[], int target, int index){
    if(numsSet.length == index){
      if (target == 0) {
        return 1;
      }
    } else {
      return (countSubSetHelper(numsSet, target - numsSet[index], index + 1) + countSubSetHelper(numsSet, target, index + 1));
  }

  return 0;

  }


  /*
  * Add testing code 
  */
  public static void main(String args[]) {

    System.out.println(" countCannonballs:" );
    System.out.println(countCannonballs(3));
    System.out.println(countCannonballs(10));

    System.out.println("\n isPalindrome:" );
    System.out.println(isPalindrome("mom"));
    System.out.println(isPalindrome("deeded"));
    System.out.println(isPalindrome("ablewasIereIsawelba"));

    System.out.println("\n isBalanced:" );
    System.out.println(isBalanced("[{[()()]}]"));
    System.out.println(isBalanced("[{[()()]}][{[()()]}]"));
    System.out.println(isBalanced("[{[()()]}{]{[()()]}]"));

    System.out.println("\n substring:" );
    substrings("abc");
    System.out.println();
    substrings("CSCI136");
    System.out.println();
    substrings("a");
    System.out.println();
    substrings("");
    System.out.println();

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

    System.out.println("\n canMakeSum:" );
    int[] numSet = {2, 5, 7, 12, 16, 21, 30};
    System.out.println(canMakeSum(numSet, 21));
    System.out.println(canMakeSum(numSet, 22));
    System.out.println(canMakeSum(numSet, 3));
    System.out.println(canMakeSum(numSet, 30));

    System.out.println("\n printSubSetSum:" );
    System.out.println(printSubSetSum(numSet, 21));
    System.out.println(printSubSetSum(numSet, 22));
    System.out.println(printSubSetSum(numSet, 3));
    System.out.println(printSubSetSum(numSet, 30));

    System.out.println("\n countSubSetSumSolutions:" );
    System.out.println(countSubSetSumSolutions(numSet, 21));
    System.out.println(countSubSetSumSolutions(numSet, 22));
    System.out.println(countSubSetSumSolutions(numSet, 3));
    System.out.println(countSubSetSumSolutions(numSet, 30));

  }
}
