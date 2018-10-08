/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m >= n) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode left = dummy;
        for(int i = 0; i < m-1; i++){
            left = left.next;
        }
        ListNode oldHead = left.next;
        ListNode prev = null;
        ListNode next = null;
        ListNode cur = oldHead;
        for(int i = 0; i < n - m +1 ; i++){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        oldHead.next = cur;
        left.next = prev;
        return dummy.next;
    }
}