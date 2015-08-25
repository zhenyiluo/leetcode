/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode prev = null;
        ListNode cur = head;
        ListNode post = null;
        while(cur != null){
            post = cur.next;
            cur.next = prev;
            prev = cur;
            cur = post;
        }
        return prev;
    }
}