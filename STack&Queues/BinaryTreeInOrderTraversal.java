import java.util.*;

// Definition for Binary Tree Node
class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    // Constructor
    TreeNode(int val) {
        this.val = val;
    }
}

public class BinaryTreeInOrderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {

        // List to store final inorder traversal
        List<Integer> result = new ArrayList<>();

        // Stack for iterative traversal
        Stack<TreeNode> stack = new Stack<>();

        // Start from root node
        TreeNode current = root;

        // Continue until current becomes null
        // and stack also becomes empty
        while(current != null || !stack.isEmpty()) {

            // Move towards extreme left node
            while(current != null) {

                // Push current node into stack
                stack.push(current);

                // Move left
                current = current.left;
            }

            // Remove top node from stack
            current = stack.pop();

            // Visit node
            result.add(current.val);

            // Move to right subtree
            current = current.right;
        }

        return result;
    }

    public static void main(String[] args) {

        BinaryTreeInOrderTraversal sol =
                new BinaryTreeInOrderTraversal();

        // Creating Tree
        /*
                 1
                  \
                   2
                  /
                 3
        */

        TreeNode root = new TreeNode(1);

        root.right = new TreeNode(2);

        root.right.left = new TreeNode(3);

        // Print inorder traversal
        System.out.println(
                "In-order Traversal: "
                + sol.inorderTraversal(root)
        );
    }
}