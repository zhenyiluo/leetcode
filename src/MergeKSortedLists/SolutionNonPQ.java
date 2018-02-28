/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class SolutionNonPQ {
    public ListNode mergeKLists(ListNode[] lists) {
        return partition(lists, 0, lists.length -1);
    }

    private ListNode partition(ListNode[] lists, int low, int high){
        if(low == high) return lists[low];
        if(low < high){
            int mid = low + ((high - low) >> 1);
            ListNode up = partition(lists, low, mid);
            ListNode down = partition(lists, mid+1, high);
            return merge(up, down);
        }else{
            return null;
        }
    }

    private ListNode merge(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = merge(l1.next, l2);
            return l1;
        }else{
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }
}