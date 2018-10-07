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
        ListNode part1 = sortList(head);
        ListNode part2 = sortList(slow);
        return mergeList(part1, part2);
    }

    private ListNode mergeList(ListNode head1, ListNode head2){
        if(head1 == null) return head2;
        if(head2 == null) return head1;
        if(head1.val < head2.val){
            head1.next = mergeList(head1.next, head2);
            return head1;
        }else{
            head2.next = mergeList(head1, head2.next);
            return head2;
        }
    }
}