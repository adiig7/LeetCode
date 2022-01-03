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
    int idx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
       TreeNode node = buildTreeHelp(preorder, inorder, 0, inorder.length-1);
        return node;
    }
    TreeNode buildTreeHelp(int[] preorder, int[] inorder, int start, int end){
        if(start > end) return null;
        System.out.println(idx);
        int curr = preorder[idx];
        idx++;
        TreeNode node = new TreeNode(curr);
        if(start == end)    return node;
        int pos = search(inorder, start, end, curr);
        node.left = buildTreeHelp(preorder, inorder, start, pos-1);
        node.right = buildTreeHelp(preorder, inorder, pos+1, end);
        return node;
    }
    int search(int[] inorder, int start, int end, int curr){
        for(int i = start; i <= end; i++)
            if(inorder[i] == curr)
                return i;
        return -1;
    }
}