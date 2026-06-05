import java.util.*;
public class HandOfStraights {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;

        if(n % groupSize != 0)
        {
            return false;
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for(int card : hand)
        {
            map.put(card, map.getOrDefault(card,0) + 1);
        }
        while(!map.isEmpty())
        {
            int curr = map.firstKey();
            for(int i = 0;i<groupSize;i++)
            {
                if(!map.containsKey(curr + i))
                {
                    return false;
                }
                map.put(curr + i, map.get(curr+i) - 1);
                if(map.get(curr + i) == 0)
                {
                    map.remove(curr + i);
                }
            }
        }
        return true;
        
    }
    public static void main(String[] args)
    {
        HandOfStraights hs = new HandOfStraights();
        int[] hand = {1,2,3,6,2,3,4,7,8};
        int groupSize = 3;
        System.out.println(hs.isNStraightHand(hand, groupSize));
    }
}
// the time complexity of this solution is O(nlogn) because of the TreeMap operations, and the space complexity is O(n) for storing the counts of the cards in the TreeMap.