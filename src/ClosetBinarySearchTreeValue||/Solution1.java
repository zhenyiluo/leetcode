/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> ret = new ArrayList<>();
        if(root == null){
            return ret;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(k, new Comparator<Pair>(){
            @Override
            public int compare(Pair p1, Pair p2){
                if(p2.dif - p1.dif < 0){
                    return -1;
                }else if(p2.dif - p1.dif > 0){
                    return 1;
                }else{
                    return 0;
                }
            }
        });
        
        Stack<TreeNode> st = new Stack<TreeNode>();
        pushLeftChildren(st, root);
        
        while(!st.isEmpty()){
            TreeNode node = st.pop();
            pq.add(new Pair(Math.abs(node.val - target), node.val));
            if(pq.size() > k){
                pq.poll();
            } 
            pushLeftChildren(st, node.right);
        }
        
        for(Pair pair : pq){
            ret.add(pair.val);
        }
        return ret;
    }
    
    private void pushLeftChildren(Stack<TreeNode> st, TreeNode root){
        while(root != null){
            st.push(root);
            root = root.left;
        }
    }
}

class Pair{
    double dif;
    int val;
    public Pair(double dif, int val){
        this.dif = dif;
        this.val = val;
    }
}