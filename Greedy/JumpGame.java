import java.util.*;

public class JumpGame {

    // Function to check whether we can reach the last index
    public static boolean canJump(int[] nums) {

        int finall = nums.length - 1;

        for(int i = nums.length  -2;i>=0;i--)
        {
            if(i + nums[i] >= finall)
            {
                finall = i;
            }
        }
        if(finall == 0)
        {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input size of array
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        // Input array elements
        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Call function
        boolean result = canJump(nums);

        // Print result
        System.out.println("Can reach last index: " + result);

        sc.close();
    }
}