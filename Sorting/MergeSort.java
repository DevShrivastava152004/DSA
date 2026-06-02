
import java.util.*;

// divide -> sort -> merge
// chota solve karo fir combine karo

public class MergeSort
{
    public static void mergeSort(int[] arr, int numberofElements)
    {
        if(numberofElements < 2)
        {
            return;
        }
        int mid = numberofElements/2;
        int[] leftArr = new int[mid];
        int[] rightArr = new int[numberofElements-mid];

        for(int i = 0;i<mid;i++)
        {
            leftArr[i] = arr[i];
        }
        for(int i = mid;i<numberofElements;i++)
        {
            rightArr[i-mid] = arr[i];
        }
        mergeSort(leftArr,mid);
        mergeSort(rightArr,numberofElements-mid);
        merge(arr,leftArr,rightArr,mid,numberofElements-mid);
    }
    private static void merge(int[] arr,int[] leftArr, int[] rightArr, int left, int right)
    {
        int i=0,j=0,k=0;
        while(i<left && j <right){
            if(leftArr[i] <= rightArr[j])
            {
                arr[k++] = leftArr[i++];
            }
            else {
                arr[k++] = rightArr[j++];
            }
        }
        while(i < left)
        {
            arr[k++] = leftArr[i++];
        }
        while(j < right)
        {
            arr[k++] = rightArr[j++];
        }
    }
        public static void main(String[] args)
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter number of elements");
            int n = sc.nextInt();

            int[] arr = new int[n];
            System.out.println("Enter " + n + " elements");
            for(int i=0;i<n;i++)
            {
            
                arr[i] = sc.nextInt();
            }
            
                mergeSort(arr,n);

                System.out.println("Sorted Array: ");
                for (int i =0; i < n; i++) 
                    System.out.println(arr[i] + " ");
                    sc.close();
                }
            }
        
    

