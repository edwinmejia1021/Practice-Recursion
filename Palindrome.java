import structure5.*;

public class Recursion {

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
  * Add testing code 
  */
  public static void main(String args[]) {

    System.out.println("\n isPalindrome:" );
    System.out.println(isPalindrome("mom"));
    System.out.println(isPalindrome("deeded"));
    System.out.println(isPalindrome("ablewasIereIsawelba"));

  }
}
