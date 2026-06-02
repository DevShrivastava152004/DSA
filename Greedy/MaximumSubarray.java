public class MaximumSubarray
{
    public int maxSubArray(int[] nums)
    {
        int n = nums.length;
        int currsum = 0;
        int maxSum = nums[0];
        for(int i=0;i<n;i++)
        {
            if(currsum < 0)
            {
                currsum = 0;
            }
            currsum = currsum + nums[i];
            maxSum = Math.max(currsum, maxSum);
        }
        return maxSum;
    }
    public static void main(String[] args) {
        MaximumSubarray obj = new MaximumSubarray();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int result = obj.maxSubArray(nums);
        System.out.println(result);
    }
}