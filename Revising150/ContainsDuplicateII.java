import java.util.*;
public class ContainsDuplicateII
{
     public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++)
        {
            if(map.containsKey(nums[i]))
            {
                int prevIndex = map.get(nums[i]);

                if(i - prevIndex <= k)
                {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }
    public static void main(String[] args)
    {
        ContainsDuplicateII cd = new ContainsDuplicateII();
        int[] nums = {1,2,3,1};
        int k = 3;
        boolean result = cd.containsNearbyDuplicate(nums, k);
        System.out.println(result);
    }
} 

// output: true
// the time complexity of this code is O(n) and the space complexity is O(n)