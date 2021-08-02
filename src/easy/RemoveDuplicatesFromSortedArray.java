package easy;

public class RemoveDuplicatesFromSortedArray {

    /**
     * Runtime = 1ms
     * Memory = 40.4MB
     */

    public int removeDuplicates(int[] nums) {

        final int length = nums.length;
        if (length == 0) return 0;

        int returnSize = 0;

        for (int num : nums) {
            if (num != nums[returnSize]) {
                returnSize++;
                nums[returnSize] = num;
            }
        }
        return returnSize + 1;
    }

}
