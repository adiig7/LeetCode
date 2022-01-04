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
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> res = helper(n);
        return res;
    }
    List<TreeNode> helper(int n){
        if(n == 1){
            List<TreeNode> ans = new ArrayList<>();
            ans.add(new TreeNode(0));
            return ans;
        }
        List<TreeNode> res = new ArrayList<>();
        for(int i = 1; i < n; i+=2){
            List<TreeNode> left = helper(i);
            List<TreeNode> right = helper(n-i-1);
            for(TreeNode l : left){
                for(TreeNode r: right){
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        return res;
    }
}