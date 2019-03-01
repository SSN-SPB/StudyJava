public class ArrayTwoTasks {

    /*40) Array-2 > no14
    https://codingbat.com/prob/p136648

    Given an array of ints, return true if it contains no 1's or it contains no 4's.

            no14([1, 2, 3]) → true
    no14([1, 2, 3, 4]) → false
    no14([2, 1]) → true
    no14([2, 3, 4]) → true*/

    public boolean no14(int[] nums) {
        boolean result1 = true;
        boolean result4 = true;

        boolean result = true;
        for (int i=0; i< nums.length; i++){
            if(nums[i]==1)
            {
                result1=false;
            }
            if(nums[i]==4)
            {
                result4=false;
            }
        }
        result=result1||result4;
        return result;


    }

}
