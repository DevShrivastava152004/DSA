import java.util.*;
class Solution {
    public List<List<Integer>> merge(int[][] intervals)
    {
        //Brute-fORCE
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0], b[0]));
        List<List<Integer>> ans = new ArrayList<>();
        int n = intervals.length;
        int i = 0;
        while(i<n ){
            int start  = intervals[i][0];
            int end = intervals[i][1];
            int j = i +1;

            while(j<n && intervals[j][0] <= end)
            {
                end = Math.max(end, intervals[j][1]);
                j++;
            }
            ans.add(Arrays.asList(start,end));
            i=j;
        }
        return ans;

    }
}
public class MergeOverlappingSubintervals
{
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] intervals = {{1,3}, {2,6}, {8,10}, {15,18}};
        List<List<Integer>> result = sol.merge(intervals);
        for(List<Integer> interval : result)
        {
            System.out.print(interval + " ");
        }
    }
}