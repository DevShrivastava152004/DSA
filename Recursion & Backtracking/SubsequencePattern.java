import java.util.*;
public class SubsequencePattern
{
    static void printS(int ind, ArrayList<Integer> ds, int s, int sum, int arr[], int n){
        if(ind == n)
        {
            if(s== sum)
            {
                for(int it: ds)
                {
                    System.out.println(it + " ");
                }
                System.out.println();
            }
            return;
        }
        ds.add(arr[ind]);
        s += arr[ind];

        printS(ind + 1,ds,s,sum,arr, n);

        s -= arr[ind];
        ds.remove(ds.size() - 1);

        printS(ind + 1,ds , s, sum, arr ,n);
    }
    public static void main(String[] args) {
        int arr[] = {1,2,1};
        int n = 3;
        int sum = 2;

        ArrayList<Integer> ds = new ArrayList<>();

        printS(0,ds,0,sum,arr,n);
    }
}