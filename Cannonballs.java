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
  * Testing code 
  */
  public static void main(String args[]) {

    System.out.println(" countCannonballs:" );
    System.out.println(countCannonballs(3));
    System.out.println(countCannonballs(10));

  }
}
