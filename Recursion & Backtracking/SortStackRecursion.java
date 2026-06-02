import java.util.*;
public class SortStackRecursion {
    // function to insert element in sorted order
    static void insertSorted(Stack<Integer> stack, int element)
    {
        // base condition:
        if(stack.isEmpty() || stack.peek() <= element)
        {
            stack.push(element);
            return;
        }
        // otherwise remove the top element
        int temp = stack.pop();// ye value stack me nhi rehti, woh temporary variable(temp) me store hoti hai jo function ka memory frame me hota hai (call stack me)

        // recursively call to find correct position
        insertSorted(stack,element);

        // push the popped element back
        stack.push(temp);
    }
    // function to sort stack using recursion
    static void sortStack(Stack<Integer> stack)
    {
        // base case
        if(stack.isEmpty()){
            return;
        }
        // pop top element
        int temp = stack.pop();

        // sort remaining stack
        sortStack(stack);

        // insert popped element in sorted order
        insertSorted(stack ,temp);
    }
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);

        System.out.println("Original Stack: " + stack);

        sortStack(stack);

        System.out.println("Sorted Stack: " + stack);
    }
}