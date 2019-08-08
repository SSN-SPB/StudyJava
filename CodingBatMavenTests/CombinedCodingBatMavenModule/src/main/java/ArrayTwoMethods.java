public class ArrayTwoMethods {

    protected int matchUp(int[] nums1, int[] nums2) {
        int counter=0;

        for (int i=0; i< nums1.length; i++){

            int prelim =Math.abs(nums1[i]- nums2[i]);
            if(prelim <=2 & nums1[i] != nums2[i])

            {

                counter++;
            }
        }

        return counter;

    }
}
