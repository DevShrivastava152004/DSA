import java.util.*;

// Definition for binary tree node
class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    // Constructor
    TreeNode(int val) {
        this.val = val;
    }
}

class Solution {

    // Function for preorder traversal
    public List<Integer> preorderTraversal(TreeNode root) {

        // List to store answer
        List<Integer> result = new ArrayList<>();

        // If tree is empty
        if (root == null) {
            return result;
        }

        // Stack for iterative traversal
        Stack<TreeNode> stack = new Stack<>();

        // Push root node
        stack.push(root);

        // Traverse until stack becomes empty
        while (!stack.isEmpty()) {

            // Remove top node
            TreeNode current = stack.pop();

            // Add current node value
            result.add(current.val);

            // Push right child first
            if (current.right != null) {
                stack.push(current.right);
            }

            // Push left child
            if (current.left != null) {
                stack.push(current.left);
            }
        }

        return result;
    }
}

// Main class name should match file name
public class BinaryTreePreOrderTraversal {

    public static void main(String[] args) {

        /*
                 1
                  \
                   2
                  /
                 3

            Preorder Traversal = 1 2 3
        */

        // Create tree
        TreeNode root = new TreeNode(1);

        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        // Create Solution object
        Solution obj = new Solution();

        // Call preorder traversal function
        List<Integer> ans = obj.preorderTraversal(root);

        // Print traversal
        System.out.println("Preorder Traversal:");

        for (int num : ans) {
            System.out.print(num + " ");
        }
    }
}