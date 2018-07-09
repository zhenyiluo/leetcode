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
        HashMap<RandomListNode, RandomListNode> hm = new HashMap<>();
        while(cur != null){
            RandomListNode newNode = new RandomListNode(cur.label);
            hm.put(cur, newNode);
            curNew.next = newNode;
            curNew = curNew.next;
            cur = cur.next;
        }

        cur = head;
        while(cur != null){
            RandomListNode curCopy = hm.get(cur);
            RandomListNode curRandom = cur.random;
            RandomListNode curRandomCopy = hm.get(curRandom);
            curCopy.random = curRandomCopy;
            cur = cur.next;
        }

        return ret.next;
    }
}