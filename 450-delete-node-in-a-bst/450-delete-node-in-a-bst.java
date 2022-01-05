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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)    return null;
        else if(key < root.val)
            root.left = deleteNode(root.left, key);
        else if(root.val < key)
            root.right = deleteNode(root.right, key);
        else{
            if(root.left == null && root.right == null){
                root = null;
                return null;
            }else if(root.left == null || root.right == null){
                TreeNode temp = (root.left != null) ? root.left : root.right;
                root = null;
                return temp;
            }else if(root.left != null && root.right != null){
                TreeNode t = root.right;
                while(t.left != null)
                    t = t.left;
                root.val = t.val;
                root.right = deleteNode(root.right, root.val);
            }
        }
        return root;
    }
}