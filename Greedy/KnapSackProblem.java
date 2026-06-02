import java.util.*;
public class KnapSackProblem {
    
 static class Item {
     int value;
     int weight;

     Item(int value, int weight)
     {
         this.value = value;
         this.weight = weight;
     }
 }
    public static double fractionalKnapsack(int W, Item[] arr)
    {
        Arrays.sort(arr, (a,b) ->
    Double.compare(
        (double) b.value / b.weight,
        (double) a.value / a.weight
    ));
    double maxValue = 0.0;

    for(Item item : arr)
    {
        if(item.weight <= W)
        {
            maxValue += item.value;
            W -= item.weight;
        }
        else
        {
            maxValue += ((double) item.value / item.weight) * W;
            break;
        }
    }
    return maxValue;
}
    public static void main(String[] args)
    {
        Item[] arr = {new Item(60, 10), new Item(100, 20), new Item(120, 30)};
        int W = 50;
        System.out.println("Maximum value in Knapsack = " + 
        fractionalKnapsack(W,arr)); // Output: 240.0
    }
}
// Time Complexity: O(n log n + n). O(n log n) to sort the items and O(n) to iterate through all the items for calculating the answer.

// Space Complexity: O(1), no additional data structure has been used.