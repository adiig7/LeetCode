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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> res = new Stack<>();
        TreeNode curr = root;
        
        while(!res.isEmpty() || curr != null){
            if(curr != null){
                res.push(curr);
                curr = curr.left;
            }else{
                curr = res.pop();
                list.add(curr.val);
                curr = curr.right;
            }
        }
        return list;
    }
}