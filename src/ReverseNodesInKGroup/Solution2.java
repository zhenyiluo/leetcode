/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k == 1) return head;
        int cnt = 0;
        ListNode cur = head;
        while(cur != null){
            cnt ++;
            cur = cur.next;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while(cnt >= k){
            cnt -= k;
            prev.next = reverseNodes(prev.next, k);
            for(int i = 0; i < k; i++){
                prev = prev.next;
            }
        }
        return dummy.next;
    }

    private ListNode reverseNodes(ListNode node, int k){
        ListNode prev = null;
        ListNode next = null;
        ListNode cur = node;
        for(int i = 0; i < k; i++){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        node.next = cur;
        return prev;
    }
}