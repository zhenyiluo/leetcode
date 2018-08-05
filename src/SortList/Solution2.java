/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(slow);
        return mergeList(left, right);
    }

    private ListNode mergeList(ListNode left, ListNode right){
        if(left == null) return right;
        if(right == null) return left;
        if(left.val < right.val){
            left.next = mergeList(left.next, right);
            return left;
        }else{
            right.next = mergeList(left, right.next);
            return right;
        }
    }
}