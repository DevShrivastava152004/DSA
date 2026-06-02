public class JumpGameII {
    public int jump(int[] nums)
    {
        int jump = 0, currMax = 0, currEnd = 0;
        for(int i=0;i<nums.length-1;i++)
        {
            currMax = Math.max(currMax, i+nums[i]);
            if(i == currEnd)
            {
                jump++;
                currEnd = currMax;
            }
        }
        return jump;
    }
    public static void main(String[] args) {
        JumpGameII jumpGame = new JumpGameII();
        int[] nums1 = {2,3,1,1,4};
        System.out.println("Output: " + jumpGame.jump(nums1)); // Output: 2

        int[] nums2 = {2,3,0,1,4};
        System.out.println("Output: " + jumpGame.jump(nums2)); // Output: 2
    }
    
}// the time complexity of this code is O(n) because we are iterating through the array once, and the space complexity is O(1) because we are using only a constant amount of space to store the jump count, current maximum reach, and current end.
