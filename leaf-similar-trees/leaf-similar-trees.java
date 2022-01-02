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
        List<Integer> res1 = new ArrayList<>();
        List<Integer> res2 = new ArrayList<>();
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
       if(root1 == null || root2 == null)
           return true;
        leaf1(root1);
        leaf2(root2);
        System.out.print(res1);
        System.out.print(res2);

        if(res1.equals(res2))    return true;
        else    return false;
    }
    
    void leaf1(TreeNode root){
        if(root == null)
            return;
        leaf1(root.left);
        if(root.left == null && root.right == null)
            res1.add(root.val);
        leaf1(root.right);
    }
     void leaf2(TreeNode root){
        if(root == null)
            return;
        leaf2(root.left);
        if(root.left == null && root.right == null)
            res2.add(root.val);
        leaf2(root.right);
    }
}