/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode str2tree(String s) {
        if(s == null || s.length() == 0) return null;

        int firstLeftP = s.indexOf('(') == -1 ? s.length() : s.indexOf('(');

        TreeNode root = new TreeNode(Integer.valueOf(s.substring(0, firstLeftP)));
        if(s.length() == firstLeftP) return root;
        s = s.substring(firstLeftP);
        int splitIndex = getFirstSplit(s);
        root.left = str2tree(s.substring(1, splitIndex));
        if(splitIndex + 1 != s.length()){
            root.right = str2tree(s.substring(splitIndex+2, s.length()-1));
        }
        return root;
    }

    private int getFirstSplit(String s){
        int left = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                left ++;
            }else if(s.charAt(i) == ')'){
                left --;
            }
            if(i != 0 && left == 0){
                return i;
            }
        }
        return s.length() -1;
    }
}