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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // ListNode temp = head;
        // int len = 0;
        // while(temp != null){
        //     len++;
        //     temp = temp.next;
        // }
        // if(n == len) return head.next;
        // len = len - n -1;
        // temp = head;
        // while(len != 0){
        //     temp = temp.next;
        //     len--;
        // }
        // temp.next = temp.next.next;
        // return head;
        ListNode first = head;
        ListNode sec = head;
        while(n>0){
            first = first.next;
            n--;
        }
        if(first == null) return head.next;
        while(first.next != null){
            first = first.next;
            sec = sec.next;
        }
        sec.next = sec.next.next;
        return head;
    }
}