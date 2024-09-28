class Solution {
    // Faith: prints preorder traversal of the binary tree starting from given root
    public static void preorderTraversal(Node root) {
        // base case
        if (root == null) {
            return;
        }
        
        System.out.print(root.data + " ");

        // prints pre-order of LST
        preorderTraversal(root.left);

        // prints pre-order of RST
        preorderTraversal(root.right);
    }
}