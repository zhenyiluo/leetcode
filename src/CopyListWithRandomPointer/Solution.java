/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode ret = new RandomListNode(-1);
        RandomListNode cur = head;
        RandomListNode curNew = ret;
        HashMap<RandomListNode,RandomListNode> hm = new HashMap<>();
        while(cur != null){
            RandomListNode copy = new RandomListNode(cur.label);
            hm.put(cur, copy);
            curNew.next = copy;
            curNew = curNew.next;
            cur = cur.next;
        }

        cur = head;
        while(cur != null){
            RandomListNode random = cur.random;
            RandomListNode randomNew = hm.get(random);
            curNew = hm.get(cur);
            curNew.random = randomNew;
            cur = cur.next;
        }
        return ret.next;
    }
}