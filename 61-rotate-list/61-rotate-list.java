/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
public ListNode rotateRight(ListNode head, int k) {
    if(head == null || head.next == null)
        return head;
    
    ListNode temph = head;
    int count = 0;
    while(temph != null){
        count++;
        temph = temph.next;
    }
    
    if(k % count == 0) 
        return head;
    
    k = count - (k%count);
    temph = head;
    while(k > 1){
        temph = temph.next;
        k--;
    }
    
    ListNode newHead = temph.next;
    temph.next = null;
    temph = newHead;
    while(temph.next !=null)
        temph = temph.next;
    temph.next = head;
    
    return newHead;
    }
}