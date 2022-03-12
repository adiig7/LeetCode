/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
     public Node copyRandomList(Node head) {
        if (head == null)
            return null;
         
        Map<Node, Node> map = new HashMap<>();
        Node dummy = new Node(0);
         
        for (Node newNodePrev = dummy, oldNode = head; oldNode != null; oldNode = oldNode.next) {
            Node newNode = new Node(oldNode.val);
            map.put(oldNode, newNode);
            newNodePrev.next = newNode;
            newNodePrev = newNode;
        }
         
        for (Node newNode = dummy.next, oldNode = head; oldNode != null; newNode = newNode.next, oldNode = oldNode.next) {
            if (oldNode.random != null) 
                newNode.random = map.get(oldNode.random);
        }
        return dummy.next;
    }
}