/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null) return null;
        int size = lists.length;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                (a, b) -> (a.val - b.val)
        );
        for(int i = 0; i < size; i++){
            if(lists[i] != null){
                pq.add(lists[i]);
            }
        }
        ListNode ret = new ListNode(0);
        ListNode cur = ret;
        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            if(node.next != null) pq.add(node.next);
            node.next = null;
            cur.next = node;
            cur = cur.next;
        }

        return ret.next;
    }
}