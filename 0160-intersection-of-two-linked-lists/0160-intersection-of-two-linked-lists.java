/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Set<ListNode> a = new HashSet<>();
        // while(headA != null){
        //     a.add(headA);
        //     headA = headA.next;
        // }
        // while(headB != null){
        //     if(a.contains(headB)){
        //         return headB;
        //     }
        //     headB = headB.next;
        // }
        // return null;
        ListNode A = headA, B = headB;
        while(A != B){
            A = (A == null) ? headB: A.next;
            B = (B == null) ? headA: B.next;
        }
        return A;
    }
}