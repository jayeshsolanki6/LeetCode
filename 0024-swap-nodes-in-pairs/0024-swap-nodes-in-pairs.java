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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode newHead = head.next;
        ListNode dummy = new ListNode(-1, head);
        while(dummy.next != null && dummy.next.next != null){
            ListNode t = dummy.next.next;
            dummy.next.next = t.next;
            t.next = dummy.next;
            dummy.next = t;
            dummy = dummy.next.next;  
        }
        return newHead;
    }
}