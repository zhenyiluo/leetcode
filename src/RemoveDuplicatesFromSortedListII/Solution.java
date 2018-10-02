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
        if(head == null) return null;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(head != null && head.next != null){
            if(head.val != head.next.val){
                cur.next = head;
                cur = cur.next;
                head = head.next;
            }else{
                int dup = head.val;
                while(head != null && head.val == dup){
                    head = head.next;
                }
            }
        }
        if(head != null){
            cur.next = head;
            cur = cur.next;
        }
        cur.next = null;
        return dummy.next;
    }
}