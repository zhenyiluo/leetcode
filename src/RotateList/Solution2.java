/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;
        int size = 0;
        ListNode cur = head;
        while(cur != null){
            size++;
            cur = cur.next;
        }
        k = k % size;
        if(k == 0) return head;
        cur = head;
        for(int i = 0; i < size - k -1; i++){
            cur = cur.next;
        }
        ListNode next = cur.next;
        ListNode newHead = next;
        cur.next = null;
        while(next.next != null){
            next = next.next;
        }
        next.next = head;
        return newHead;
    }
}