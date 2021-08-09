package medium;

import java.util.Arrays;

/**
 * Runtime : 8ms,
 * Memory : 40.1MB
 * 3차
 */

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int length = nums.length;
        if(length == 0) return -1;


        Arrays.sort(nums);

        int minDiff = Integer.MAX_VALUE;
        int sum;
        int result = 0;

        for(int i = 0; i < length - 2; i++) {
            int nextInt = i + 1;
            int k = length - 1;

            while(nextInt < k) {
                sum = nums[i] + nums[nextInt] + nums[k];

                int diff = Math.abs(sum - target);
                if(diff == 0) {
                    return sum;
                }

                if(diff < minDiff) {
                    minDiff = diff;
                    result = sum;
                }

                if(sum < target) {
                    nextInt++;
                }
                else {
                    k--;
                }
            }
        }
        return result;
    }

}