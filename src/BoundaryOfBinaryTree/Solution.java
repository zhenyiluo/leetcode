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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if(root == null) return ret;

        List<TreeNode> left = new ArrayList<>();
        List<TreeNode> right = new ArrayList<>();
        List<TreeNode> leaves = new ArrayList<>();

        left.add(root);
        right.add(root);
        if(root.left != null){
            dfsLeft(root.left, left);
        }
        if(root.right != null){
            dfsRight(root.right, right);
        }

        dfsLeaves(root, leaves);

        HashSet<TreeNode> hs = new HashSet<>();
        for(TreeNode node: left){
            hs.add(node);
            ret.add(node.val);
        }

        for(TreeNode node: leaves){
            if(hs.contains(node)){
                continue;
            }
            hs.add(node);
            ret.add(node.val);
        }

        for(TreeNode node: right){
            if(hs.contains(node)){
                continue;
            }
            hs.add(node);
            ret.add(node.val);
        }
        return ret;
    }

    private void dfsLeft(TreeNode node, List<TreeNode> list){
        list.add(node);
        if(node.left != null){
            dfsLeft(node.left, list);
        }else if (node.right != null){
            dfsLeft(node.right, list);
        }
    }

    private void dfsRight(TreeNode node, List<TreeNode> list){
        list.add(0, node);
        if(node.right != null){
            dfsRight(node.right, list);
        }else if(node.left != null){
            dfsRight(node.left, list);
        }
    }

    private void dfsLeaves(TreeNode node, List<TreeNode> list){
        if(node.left == null && node.right == null){
            list.add(node);
        }
        if(node.left != null){
            dfsLeaves(node.left, list);
        }
        if(node.right != null){
            dfsLeaves(node.right, list);
        }
    }
}