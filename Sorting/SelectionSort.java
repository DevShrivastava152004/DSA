// minimum element choose karo aur correct position pe daalo
import java.util.*;
public class SelectionSort {
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for(int i=0;i<n;i++)
        {
            int minIndex = i;
            for(int j =i+1;j<n;j++)
            {
                if(arr[j] < arr[minIndex])
                {
                    minIndex = j;

                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    } 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter the number");
        n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter"+ n +" elements");
        for(int i =0 ;i<n;i++)
        {
            arr[i] = sc.nextInt();
        }
        SelectionSort obj = new SelectionSort();
        obj.selectionSort(arr);

        System.out.println("Sorted array");
        for(int i=0;i<n;i++)
        {
            System.out.println(arr[i] + " ");
        }
        sc.close();
    }
}
