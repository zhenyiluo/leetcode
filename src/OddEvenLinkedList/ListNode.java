/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode oddDummy = new ListNode(-1);
        ListNode evenDummy = new ListNode(-1);
        ListNode curOdd = oddDummy;
        ListNode curEven = evenDummy;
        int flag = 0;
        ListNode cur = head;
        while (cur != null) {
            flag ^= 1;
            if (flag == 1) {
                curOdd.next = cur; 
                curOdd = curOdd.next;
            } else {
                curEven.next = cur;
                curEven = curEven.next;
            }
            cur = cur.next;
        }
        curEven.next = null;
        curOdd.next = evenDummy.next;
        return oddDummy.next;
    }
}