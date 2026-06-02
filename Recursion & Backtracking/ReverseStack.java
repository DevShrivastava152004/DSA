import java.util.*;
public class ReverseStack {
    public static void insertatLast(Stack<Integer> st, int element)
    {
        if(st.isEmpty())
        {
            st.push(element);
            return;
        }
    int top = st.pop();
    insertatLast(st,element);
    st.push(top);
    }
    static void reverse(Stack<Integer> st)
    {
        if(st.isEmpty())
        {
            return;
        }
        int temp = st.pop();
        reverse(st);
        insertatLast(st,temp);
    }
    public static void main(String[] args) {
        {
            Stack<Integer> st = new Stack<>();
            st.push(2);
            st.push(3);
            st.push(1);
            st.push(4);
            System.out.println("Original Stack: " + st);
            reverse(st);
            System.out.println("Reversed Stack: " + st);
        }
    }
}
