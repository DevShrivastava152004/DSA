public class MergeTripletsToFormTargetTriplets {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] maxValues = new int[3];
        for(int[] triplet : triplets)
        {
            // check if the current triplet can contribute to the target
            if(triplet[0] <= target[0] && triplet[1] <= target[1] && triplet[2] <= target[2])
            {
                // update max values for each element
                maxValues[0] = Math.max(maxValues[0], triplet[0]);
                maxValues[1] = Math.max(maxValues[1], triplet[1]);
                maxValues[2] = Math.max(maxValues[2], triplet[2]);
            }
        }
        return maxValues[0] == target[0] && maxValues[1] == target[1] && maxValues[2] == target[2];

    }
    public static void main(String[] args)
    {
        MergeTripletsToFormTargetTriplets mt = new MergeTripletsToFormTargetTriplets();
        int[][] triplets = {{2,5,3},{1,8,4},{1,7,5}};
        int[] target = {2,7,5};
        System.out.println(mt.mergeTriplets(triplets, target));
    }
}
// the time complexity of this solution is O(n) where n is the number of triplets, and the space complexity is O(1) since we are using a fixed amount of space to store the max values.
