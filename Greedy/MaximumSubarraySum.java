public class MaximumSubarraySum {
    public int maxSubArray(int[] nums)
    {
        int  currSum  = 0;
        int maxSum = nums[0];
        for(int i  =0;i<nums.length;i++)
        {
            if(currSum < 0)
            {
                currSum = 0;
            }
            currSum = Math.max(currSum , currSum + nums[i]);
            maxSum = Math.max(maxSum , currSum);
        }
        return maxSum;
    }
    public static void main(String[] args) {
        MaximumSubarraySum sol = new MaximumSubarraySum();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int result = sol.maxSubArray(nums);
        System.out.println(result);
    }
}
// the time complexity of this code is O(n) and the space complexity is O(1) because we are using only a constant amount of space to store the current sum and maxium sum.