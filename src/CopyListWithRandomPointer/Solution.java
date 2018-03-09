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
        HashMap<RandomListNode, RandomListNode> hm = new HashMap<>();
        RandomListNode curOld = head;
        RandomListNode ret = new RandomListNode(0);
        RandomListNode curNew = ret;
        while(curOld != null){
            RandomListNode copy = new RandomListNode(curOld.label);
            hm.put(curOld, copy);
            curNew.next = copy;
            curNew = curNew.next;
            curOld = curOld.next;
        }
        curOld = head;
        while(curOld != null){
            RandomListNode random = curOld.random;
            RandomListNode randomNew = hm.get(random);
            curNew = hm.get(curOld);
            curNew.random = randomNew;
            curOld = curOld.next;
        }
        return ret.next;
    }
}