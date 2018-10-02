/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode l1 = new ListNode(-1);
        ListNode l2 = new ListNode(-1);
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode cur = head;
        while(cur != null){
            if(cur.val < x){
                cur1.next = cur;
                cur = cur.next;
                cur1 = cur1.next;
                cur1.next = null;
            }else{
                cur2.next = cur;
                cur = cur.next;
                cur2 = cur2.next;
                cur2.next = null;
            }
        }
        cur1.next = l2.next;
        return l1.next;
    }
}