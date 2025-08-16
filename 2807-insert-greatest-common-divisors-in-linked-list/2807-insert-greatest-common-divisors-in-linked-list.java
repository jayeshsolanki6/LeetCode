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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode temp = head;
        while(temp.next != null){
            int gcd = gcd(temp.val, temp.next.val);
            ListNode t = temp.next;
            temp.next = new ListNode(gcd, t);
            temp = temp.next.next;
        }
        return head;
    }
    int gcd(int x, int y){
        while(x != 0 && y != 0){
            if(x > y){
                x -= y;
            } else{
                y -= x;
            }
        }
        if(x == 0) return y;
        return x;
    }
}