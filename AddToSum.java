import structure5.*;

public class Recursion {

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
  * Add testing code 
  */
  public static void main(String args[]) {
    
    System.out.println("\n printSubSetSum:" );
    System.out.println(printSubSetSum(numSet, 21));
    System.out.println(printSubSetSum(numSet, 22));
    System.out.println(printSubSetSum(numSet, 3));
    System.out.println(printSubSetSum(numSet, 30));

  }
}
