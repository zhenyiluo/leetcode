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
        ListNode prev = null;
        cur = dummy;
        while(cnt >= k){
            prev = cur;
            ListNode first = cur.next;
            for(int i = 0; i < k ; i++){
                cur = cur.next;
            }
            ListNode next = cur.next;
            cur.next = null;
            prev.next = reverse(first, k);
            first.next = next;
            cur = first;
            cnt -= k;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode node, int k){
        ListNode prev = null;
        while(node != null){
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }
}