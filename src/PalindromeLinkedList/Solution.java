/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        Stack<ListNode> st = new Stack<>();
        ListNode cur = head;
        while(cur != null){
            st.push(cur);
            cur = cur.next;
        }
        cur = head;
        while(!st.isEmpty()){
            if(cur.val != st.pop().val){
                return false;
            }
            cur = cur.next;
        }
        return true;
    }
}