/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }
    boolean validate(TreeNode root, TreeNode minNode, TreeNode maxNode){
        if(root == null)
            return true;
        if((minNode != null && root.val <= minNode.val) || (maxNode != null && root.val >= maxNode.val))
                return false;
        return validate(root.left, minNode, root) && validate(root.right, root, maxNode);
    }
}