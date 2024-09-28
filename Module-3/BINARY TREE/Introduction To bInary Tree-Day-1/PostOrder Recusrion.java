class Solution {
	public static void postorderTraversal(Node root) {
		// TC: O(n), SC: O(height)

        if(root == null){
            return;
        }

        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.print(root.data + " ");
        
	}
}