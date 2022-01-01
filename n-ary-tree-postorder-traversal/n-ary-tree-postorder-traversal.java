/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
   
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;
        post(root, res);
        res.add(root.val);
        return res;
    }
     public void post(Node root, List<Integer> res){
        if(root == null)
            return;
        else{
        for(Node child: root.children){
            post(child, res);
            res.add(child.val);
        }
        }
    }
}