public class MergeTripletsToFormTriplets {
    public boolean mergeTriplets(int[][] triplets, int[] target)
    {
        int[] maxValues = new int[3];
        for(int[] triplet : triplets)
        {
            if(triplet[0] <= target[0] && triplet[1] <= target[1] && triplet[2] <= target[2])
            {
                maxValues[0] = Math.max(maxValues[0], triplet[0]);
                maxValues[1] = Math.max(maxValues[1], triplet[1]);      
                maxValues[2] = Math.max(maxValues[2], triplet[2]);
            }
        }
        return maxValues[0] == target[0] && maxValues[1] == target[1] && maxValues[2] == target[2];
    }
    public static void main(String[] args) {
        MergeTripletsToFormTriplets solution = new MergeTripletsToFormTriplets();
        int[][] triplets = {{2, 5, 3}, {1, 8, 4}, {1, 7, 5}};
        int[] target = {2, 7, 5};
        boolean result = solution.mergeTriplets(triplets, target);
        System.out.println(result); // Output: true
    }
}
