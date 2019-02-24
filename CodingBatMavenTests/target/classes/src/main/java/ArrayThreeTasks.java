package src.main.java;

public class ArrayThreeTasks {

    /*32)Java Array-3 > linearIn
    https://codingbat.com/prob/p134022

    Given two arrays of ints sorted in increasing order, outer and inner, return true if all of the numbers in inner appear in outer. The best solution makes only a single "linear" pass of both arrays, taking advantage of the fact that both arrays are already in sorted order.

    linearIn([1, 2, 4, 6], [2, 4]) → true
    linearIn([1, 2, 4, 6], [2, 3, 4]) → false
    linearIn([1, 2, 4, 4, 6], [2, 4]) → true

    Decision:*/
    public boolean linearIn(int[] outer, int[] inner) {
        boolean compareArrays=true;


        for (int i=0; i<inner.length; i++)
        {

            boolean interimcompareArrays=false;
            for (int o=0; o<outer.length; o++)
            {

                if (inner[i]==outer[o])
                {
                    interimcompareArrays=true;
                    break;
                }


            }

            if (interimcompareArrays==false)
            {
                compareArrays=false;
                break;
            }

        }

        return compareArrays;

    }
}
