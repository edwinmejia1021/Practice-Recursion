import structure5.*;

public class Recursion {

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
  * Testing code 
  */
  public static void main(String args[]) {

    System.out.println("\n countSubSetSumSolutions:" );
    System.out.println(countSubSetSumSolutions(numSet, 21));
    System.out.println(countSubSetSumSolutions(numSet, 22));
    System.out.println(countSubSetSumSolutions(numSet, 3));
    System.out.println(countSubSetSumSolutions(numSet, 30));

  }
}
