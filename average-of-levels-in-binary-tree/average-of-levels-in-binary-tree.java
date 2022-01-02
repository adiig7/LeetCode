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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> res = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            double ans = 0;
            int queueLength = queue.size();
            for(int i = 0; i < queueLength; i++){
            TreeNode t = queue.poll();
            ans += t.val;
            if(t.left != null)
                queue.add(t.left);
            if(t.right != null)
                queue.add(t.right);
            }
            res.add(ans/queueLength);
        }
        return res;
    }
}