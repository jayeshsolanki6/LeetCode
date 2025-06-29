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
        if(head == null) return head;
        ListNode first = null;
        ListNode mid = head;
        ListNode second = null;
        while(mid != null){
             second = mid.next;
             mid.next = first;
             first = mid;
             mid = second;
        }
        return first;
    }
}