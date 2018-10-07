/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    ListNode dummy = new ListNode(0);
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
        ListNode cur = dummy;
        while(head1 != null && head2 != null){
            if(head1.val < head2.val){
                cur.next = head1;
                head1 = head1.next;
            }else{
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
            cur.next = null;
        }
        if(head1 != null){
            cur.next = head1;
        }
        if(head2 != null){
            cur.next = head2;
        }
        return dummy.next;
    }
}