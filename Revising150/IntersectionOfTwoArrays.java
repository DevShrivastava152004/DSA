public class IntersectionOfTwoArrays{
    public int[] intersect(int[] nums1, int[] nums2) {
        // store frequency of elements from nums1
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums1)
        {
            map.put(num, map.getOrDefault(num,0) + 1);
        }
        // List to store intersaction elements
        List<Integer> result = new ArrayList<>();

        // Traverse nums2
        for(int num:nums2)
        {
            // If number exists in map and frequency > 0
            if(map.containsKey(num) && map.get(num) > 0)
            {
                // Add it to result
                result.add(num);

                // Decrease its frequency
                map.put(num, map.get(num) - 1);
            }
        }
        // Convert List<Integer> to int[]
        int[] ans = new int[result.size()];
        for(int i=0;i<result.size();i++)
        {
            ans[i] = result.get(i);
        }
        return ans;
    }
    public static void main(String[] args)
    {
        IntersectionOfTwoArrays solution = new IntersectionOfTwoArrays();
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] result = solution.intersect(nums1, nums2);
        System.out.println(Arrays.toString(result)); // Output: [2, 2]
    }
} // the time complexity of this code is O(n + m) where n and m are the lengths of nums1 and nums2 respectively. The space complexity is O(min(n, m)) due to the HashMap storing frequencies.