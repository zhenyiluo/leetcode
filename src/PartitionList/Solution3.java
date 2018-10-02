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
        while(head != null){
            if(head.val < x){
                cur1.next = head;
                cur1 = cur1.next;
            }else{
                cur2.next = head;
                cur2 = cur2.next;
            }
            head = head.next;
        }
        cur2.next = null;
        cur1.next = l2.next;
        return l1.next;
    }
}