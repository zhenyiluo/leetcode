/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null);
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while(head != null){
            while(head.next != null && head.val == head.next.val){
                head = head.next;
            }
            if(prev.next == head){
                prev = prev.next;
            }else{
                prev.next = head.next;
            }
            head = head.next;
        }
        return dummy.next;
    }
}