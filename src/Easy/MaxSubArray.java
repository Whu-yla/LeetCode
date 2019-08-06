package Easy;

public class MaxSubArray {
    public static int maxSubArray(int[] nums) {
        int current = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (current < 0) {
                current = nums[i];
            } else {
                current += nums[i];
            }

            if (sum < current) {
                sum = current;
            }
        }
        return sum;
    }
}
