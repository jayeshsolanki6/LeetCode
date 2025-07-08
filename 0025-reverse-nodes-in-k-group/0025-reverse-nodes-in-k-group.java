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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k <= 1) return head;
        int len = 0;
        ListNode temp = head;
        while(temp != null){
            len++;
            temp = temp.next;
        }
        ListNode dummy = new ListNode(-1, head);
        ListNode res = dummy;
        int times = len/k;
        while(times != 0){
            dummy = reverse(dummy, k);
            times--;
        }
        return res.next;
    }
    ListNode reverse(ListNode head, int n){
        ListNode temp = head.next, first = head.next, 
                 sec = head.next.next, third = head.next.next.next;
        while(n-1>0){
            sec.next = first;
            first = sec;
            sec = third;
            if(third == null){
                break;
            }
            third = third.next;
            n--;
        }
        head.next.next =  sec;
        head.next = first;
        return temp;

    }
}