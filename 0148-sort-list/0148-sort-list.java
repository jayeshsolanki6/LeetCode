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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode list1 = head;
        ListNode list2 = findMiddle(head);

        list1 = sortList(list1);
        list2 = sortList(list2);

        return merge(list1, list2);

    }
    ListNode findMiddle(ListNode head){
        ListNode slow = head, fast = head, prev = null;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        return slow;
    }
    ListNode merge(ListNode list1, ListNode list2){
       ListNode dummy = new ListNode(0, null);
        ListNode temp = dummy;

        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                temp.next = list1;
                list1 = list1.next;
            } else{
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        if(list1 != null){
            temp.next = list1;
        } else{
            temp.next = list2;
        }
        return dummy.next;
    }
}



// List<Integer> arr = new ArrayList<>();
//         ListNode temp = head;
//         while(temp != null){
//             arr.add(temp.val);
//             temp = temp.next;
//         }
//         Collections.sort(arr);
//         temp = head;
//         for(int i = 0; i<arr.size(); i++){
//             temp.val = arr.get(i);
//             temp = temp.next;
//         }
//         return head;