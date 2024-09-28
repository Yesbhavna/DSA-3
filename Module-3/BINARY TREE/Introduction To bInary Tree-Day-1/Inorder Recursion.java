class Solution {
    // inorder: inorder(LST) + root.data + inroder(RST)
    // faith: prints inorder of BT from given root
    public static void inorderTraversal(Node root) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left);

        System.out.print(root.data + " ");

        inorderTraversal(root.right);
    }
}