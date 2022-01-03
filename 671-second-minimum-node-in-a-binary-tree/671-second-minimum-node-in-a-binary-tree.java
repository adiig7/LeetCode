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
    Set<Integer> res = new HashSet<Integer>();
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null)
            return 0;
        findSecondMinimumValue(root.left);
        res.add(root.val);
        findSecondMinimumValue(root.right);
        ArrayList<Integer> al = new ArrayList<>(res);
        Collections.sort(al);
        if(al.size() == 1)  return -1;
        else    return al.get(1);        
    }
}