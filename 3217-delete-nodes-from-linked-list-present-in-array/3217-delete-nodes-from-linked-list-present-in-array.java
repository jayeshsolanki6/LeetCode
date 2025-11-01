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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }
        ListNode list = new ListNode(0, null);
        ListNode temp = head, dummy = list;
        while(temp != null){
            if(!set.contains(temp.val)){
                list.next = new ListNode(temp.val, null);
                list = list.next;
            }
            temp = temp.next;
        }
        return dummy.next;
    }
}