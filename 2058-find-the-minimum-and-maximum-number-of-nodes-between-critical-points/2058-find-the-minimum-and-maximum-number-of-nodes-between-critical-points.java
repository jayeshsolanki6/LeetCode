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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int fcp = -1; // first critical point
        int lcp = -1; // last critical point
        int max = -1;
        int min = -1;
        int i = 1;
        int prev = head.val;
        head = head.next;
        while(head.next != null){
            if((head.val > prev && head.val > head.next.val) ||
             (head.val < prev && head.val < head.next.val)){
                if(lcp == -1){
                    lcp = i;
                } else if(fcp == -1){
                    fcp = lcp;
                    lcp = i;
                    max = min = i-fcp; 
                } else{
                    max = i-fcp;
                    min = Math.min(min, i-lcp);
                    lcp = i;
                }
            }
            i++;
            prev = head.val;
            head = head.next;
        }
        return new int[]{min, max};
    }
}