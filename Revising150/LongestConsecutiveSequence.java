import java.util.*;
public class LongestConsecutiveSequence
{
    public int longestConsecutive(int[] nums) {

        if(nums.length == 0)
        {
            return 0;
        }
        HashSet<Integer> numSet = new HashSet<>();
        for(int i=0;i<nums.length;i++)
        {
            numSet.add(nums[i]);
        }
        int longestSub = 1;

        for(int num : numSet)
        {
            if(numSet.contains(num-1))
            {
                continue;
            }
            else {
                int currentNum = num;
                int currentSub = 1;
                while(numSet.contains(currentNum+1)){
                    currentNum++;
                    currentSub++;
                }
                longestSub = Math.max(longestSub , currentSub);
            }
        }
        return longestSub;
        
    }
    public static void main(String[] args) {
        LongestConsecutiveSequence l = new LongestConsecutiveSequence();
        int[] nums = {100,4,200,1,3,2};
        System.out.println(l.longestConsecutive(nums));
    }
} // the time complexity of this solution is O(n) because we are iterating through the array once to add elements to the set and then iterating through the set to find the longest consecutive sequence. The space complexity is also O(n) because we are using a set to store the unique elements from the array.