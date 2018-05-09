/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution2 {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode nextHead = head.next;
        ListNode newHead = reverseList(head.next);
        nextHead.next = head;
        head.next = null;
        return newHead;
    }
}