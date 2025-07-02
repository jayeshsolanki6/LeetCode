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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return head;
        // List<Integer> arr = new ArrayList<>();
        // ListNode temp = head;
        // while(temp != null){
        //     arr.add(temp.val);
        //     if(temp.next != null) temp = temp.next.next;
        //     else break;
        // }
        // temp = head.next;
        // while(temp != null){
        //     arr.add(temp.val);
        //     if(temp.next != null) temp = temp.next.next;
        //     else break;
        // }
        // temp = head;
        // for(int i = 0; i<arr.size(); i++){
        //     temp.val = arr.get(i);
        //     temp = temp.next;
        // }
        // return head;
        ListNode odd = head, even = head.next, temp = even;
        while(even != null && even.next != null){
            odd.next = even.next; 
            odd = odd.next;   
            even.next = odd.next;
            even = even.next;
        }
        odd.next = temp;
        return head;
    }
}