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
        List<TreeNode> res = new ArrayList<>();
    Set<Integer> set = new HashSet<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for(int i : to_delete)
            set.add(i);
        root =  helper(root);
        if(root != null)
            res.add(root);
        return res;
    }
    public TreeNode helper(TreeNode root){
        if(root == null)    return null;
        root.left = helper(root.left);
        root.right = helper(root.right);
            if(set.contains(root.val)){
                if(root.left != null)
                    res.add(root.left);
                if(root.right != null)
                    res.add(root.right);
                root = null;
            }       
        
        return root;
    }
}