/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode prev = dummyNode;
        ListNode cur = head;
        while(cur != null){
            if(cur.val == val){
                cur = cur.next;
                prev.next = cur;
            }else{
                prev = prev.next;
                cur = cur.next;
            }
        }
        return dummyNode.next;
    }
}