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
        if(head == null || head.next == null){
            return head;
        }
        int count = count(head);
        k = k % count;
        if(k == 0){
            return head;
        }
        ListNode cur = head;
        for(int i = 1; i < count - k; i++){
            cur = cur.next;
        }
        ListNode newHead = cur.next;
        cur.next = null;
        ListNode newCur = newHead;
        while(newCur.next != null){
            newCur = newCur.next;
        }
        newCur.next = head;
        return newHead;
    }

    private int count(ListNode node){
        int ret = 0;
        while(node != null){
            ret ++;
            node = node.next;
        }
        return ret;
    }
}