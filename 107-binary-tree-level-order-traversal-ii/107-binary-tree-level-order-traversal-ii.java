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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            int n = que.size();
            List<Integer> t = new ArrayList<>();
            for(int i = 0; i < n; i++){
                TreeNode temp = que.poll();
                t.add(temp.val);
                if(temp.left != null)
                    que.add(temp.left);
                if(temp.right != null)
                    que.add(temp.right);
            }
            res.add(t);
        }
        Collections.reverse(res);
        return res;
    }
}