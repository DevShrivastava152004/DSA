import java.util.*;

public class HandOfStraight {

    // Function to check if cards can be arranged in consecutive groups
    public static boolean isNStraightHand(int[] hand, int groupSize) {

        int n = hand.length;

        // If total cards are not divisible by groupSize
        if (n % groupSize != 0) {
            return false;
        }

        // TreeMap stores elements in sorted order
        TreeMap<Integer, Integer> mp = new TreeMap<>();

        // Count frequency of each card
        for (int handNumber : hand) {
            mp.put(handNumber, mp.getOrDefault(handNumber, 0) + 1);
        }

        // Continue until map becomes empty
        while (!mp.isEmpty()) {

            // Get smallest card
            int curr = mp.firstKey();

            // Create consecutive group
            for (int i = 0; i < groupSize; i++) {

                int card = curr + i;

                // If card does not exist
                if (!mp.containsKey(card)) {
                    return false;
                }

                // Decrease frequency
                mp.put(card, mp.get(card) - 1);

                // Remove if frequency becomes 0
                if (mp.get(card) == 0) {
                    mp.remove(card);
                }
            }
        }

        return true;
    }

    // Main Function
    public static void main(String[] args) {

        int[] hand = {1, 2, 3, 6, 2, 3, 4, 7, 8};
        int groupSize = 3;

        boolean ans = isNStraightHand(hand, groupSize);

        System.out.println(ans);
    }
}