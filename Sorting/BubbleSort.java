import java.util.*;
public class BubbleSort
{

    public void bubbleSort(int[] arr)
    {
        int n = arr.length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n-i-1;j++)
            {
                if(arr[j] > arr[j+1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the numbers to sort");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter" + n + "Elements:");
        for(int i = 0;i<n;i++)
        {
            arr[i] = sc.nextInt();
        }
        BubbleSort obj = new BubbleSort();
        obj.bubbleSort(arr);

        System.out.println("Sorted Array: ");
        for(int i=0;i<n;i++)
        {
            System.out.println(arr[i] + " ");
        }
        sc.close();
    }

    }

