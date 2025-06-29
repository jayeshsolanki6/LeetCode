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
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode first = head;
        ListNode mid = head.next;
        ListNode second = head.next.next;
        head.next = null;
        while(mid != null){
             mid.next = first;
             first = mid;
             mid = second;
             if(mid == null) return first;
             second = second.next;
        }

        return first;
    }
}