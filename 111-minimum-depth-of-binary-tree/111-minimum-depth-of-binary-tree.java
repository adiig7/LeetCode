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
    int res = 0, flag = -1;
    public int minDepth(TreeNode root) {
        if(root == null)    return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
            TreeNode t = q.poll();
            if(t.left == null && t.right == null)
                flag = 0;
            if(t.left != null)
                q.add(t.left);
            if(t.right != null)
                q.add(t.right);
            }
            if(flag == 0)   break;
            res++;
        }
        return res+1;
    }
}