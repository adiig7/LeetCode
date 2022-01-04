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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root == null)
            return null;
        root = inorder(root, target);
        return root;
    }
    TreeNode inorder(TreeNode root, int target){
        if(root == null)    return null;
        root.left = inorder(root.left, target);
        root.right = inorder(root.right, target);
        if(root.left == null && root.right == null){
            if(root.val == target)
                root = null;
        }
        return root;
    }
}