public class JumpGameI
{
    public boolean canJump(int[] nums)
    {
        int n = nums.length;
        int maxIndex = 0;
        for(int i =0 ;i < n;i++)
        {
            if(i>maxIndex )
                return false;
            maxIndex = Math.max(maxIndex, i+nums[i]);
        }
        return true;
    }
    public static void main(String[] args) {
        JumpGameI jumpGame = new JumpGameI();
        int[] nums1 = {2,3,1,1,4};
        System.out.println("Output: " + jumpGame.canJump(nums1)); // Output: true

        int[] nums2 = {3,2,1,0,4};
        System.out.println("Output: " + jumpGame.canJump(nums2)); // Output: false
    }

}