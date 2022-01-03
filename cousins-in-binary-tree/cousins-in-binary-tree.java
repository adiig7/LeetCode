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
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null)    return false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int levelX = -1, levelY = -2, lev = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode temp = q.poll();
                if(temp.left != null && temp.right != null)
                    if((temp.left.val == x && temp.right.val == y)|| (temp.left.val == y && temp.right.val == x))   return false;
                if(temp.val == x)   levelX = lev;
                if(temp.val == y)   levelY = lev;
                if(temp.left != null)   q.add(temp.left);
                if(temp.right != null)  q.add(temp.right);            }
            lev++;
        }
        return levelX == levelY;
    }
}