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
    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode(-1, null);
        ListNode temp = dummy;
        int value = 0;
        while(head != null){
            if(head.val == 0){
                if(value > 0){
                    temp.next = new ListNode(value);
                    temp = temp.next;
                    value = 0;
                }
            } else{
                value += head.val;
            }
            head = head.next;
        }
        return dummy.next;
    }
}