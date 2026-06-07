import java.util.Arrays;

public class MaximizeSumOfArrayAfterKNegations {
    public int largestSumAfterKNegations(int[] nums, int k) {

        // Sort array so negative numbers come first
        Arrays.sort(nums);

        // Convert negative numbers to positive
        for (int i = 0; i < nums.length && k > 0; i++) {
            if (nums[i] < 0) {
                nums[i] = -nums[i];
                k--;
            }
        }

        int sum = 0;
        int minAbs = Integer.MAX_VALUE;

        // Calculate sum and find minimum absolute value
        for (int num : nums) {
            sum += num;
            minAbs = Math.min(minAbs, Math.abs(num));
        }

        // If k is odd, flip the smallest absolute value once
        if (k % 2 == 1) {
            sum -= 2 * minAbs;
        }

        return sum;
    }
    public static void main(String[] args) {
        MaximizeSumOfArrayAfterKNegations ms = new MaximizeSumOfArrayAfterKNegations();
        int[] nums = {4, 2, 3};
        int k = 1;
        System.out.println(ms.largestSumAfterKNegations(nums, k)); // Output: 5
    }
}