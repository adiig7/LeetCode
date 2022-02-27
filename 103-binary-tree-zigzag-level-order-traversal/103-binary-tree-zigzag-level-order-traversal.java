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
    List<List<Integer>> res = new ArrayList<>();
    boolean ltr = true;
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        zigzag(root);
        return res;
    }
    public void zigzag(TreeNode root){
        if(root == null)
            return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
        List<Integer> temp = new ArrayList<>();
          int n = q.size();
            for(int i = 0; i < n; i++){
                TreeNode t = q.poll();
                temp.add(t.val);
                if(t.left != null)
                    q.add(t.left);
                if(t.right != null)
                    q.add(t.right);
            }
            if(!ltr)    Collections.reverse(temp);
            res.add(temp);
            ltr = !ltr;
        }
    }
}