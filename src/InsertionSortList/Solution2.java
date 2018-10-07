/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode ret = new ListNode(0);
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            ListNode prev = ret;
            while(prev.next != null && prev.next.val < cur.val){
                prev = prev.next;
            }
            cur.next = prev.next;
            prev.next = cur;
            cur = next;
        }
        return ret.next;
    }
}