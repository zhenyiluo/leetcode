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
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null) return ret;
        List<Element> elements = new ArrayList<>();
        List<List<Element>> tmp = new ArrayList<>();
        dfs(root, 0, 0, 0, elements);
        for(int i = min; i <= max; i++){
            tmp.add(new ArrayList<>());
            ret.add(new ArrayList<>());
        }
        for(Element e : elements){
            tmp.get(e.col - min).add(e);
        }
        for(List<Element> list : tmp){
            Collections.sort(list, (a, b) -> {
                if(a.row != b.row){
                    return a.row - b.row;
                }else{
                    return a.seq - b.seq;
                }
            });
        }

        for(int i = 0; i< tmp.size(); i++){
            List<Element> eList = tmp.get(i);
            for(Element e: eList){
                ret.get(i).add(e.val);
            }
        }
        return ret;
    }

    private void dfs(TreeNode node, int row, int col, int seq, List<Element> elements){
        min = Math.min(min, col);
        max = Math.max(max, col);
        elements.add(new Element(row, col, seq, node.val));
        if(node.left != null){
            dfs(node.left, row + 1, col -1, seq + 1, elements);
        }
        if(node.right != null){
            dfs(node.right, row + 1, col + 1, seq + 1, elements);
        }
    }
}

class Element{
    int row;
    int col;
    int seq;
    int val;
    public Element(int row, int col, int seq, int val){
        this.row = row;
        this.col = col;
        this.seq = seq;
        this.val = val;
    }
}