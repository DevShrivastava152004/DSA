// - sorted part maintain karo
// - element ko correct place pe insert karo
// - shifting hoti hai ispe
import java.util.*;
public class InsertionSort{
    public void insertionsort(int[] arr)
    {
        int n = arr.length;
        for(int i=1;i<n;i++)
        {
            int key = arr[i];
            int j = i-1;

            while(j >= 0 && arr[j] > key)
            {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter the number");
        n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter" + n + " Elements");
        for (int i =0; i < n; i++) {
            
            arr[i] = sc.nextInt();
        }
        InsertionSort obj = new InsertionSort();
        obj.insertionsort(arr);

        System.out.println("After Insertion Sort-");
        for(int i=0;i<n;i++)
        {
            System.out.println(arr[i] + " ");
        }
        sc.close();
    }
}