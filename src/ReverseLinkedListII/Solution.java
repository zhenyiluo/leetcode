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
        if(head == null || head.next == null || m == n) return head;
        ListNode cur = head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode next = null;
        int cnt = 1;
        while(cnt < m){
            prev = cur;
            cur = cur.next;
            cnt++;
        }
        ListNode left = prev;
        ListNode tmpTail = cur;
        prev = null;
        for(int i = 0; i < n - m + 1; i++){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        tmpTail.next = cur;
        left.next = prev;
        return dummy.next;
    }
}