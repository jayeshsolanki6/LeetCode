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
    public ListNode middleNode(ListNode head) {
        // int len = 0;
        // ListNode tamp = head;
        // while(tamp != null){
        //     len++;
        //     tamp = tamp.next;
        // }
        // len /= 2;
        // while(len>0){
        //     head = head.next;
        //     len--;
        // }
        // return head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}