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
        
        dfs(root, pq, k, target);
        for(Pair pair : pq){
            ret.add(pair.val);
        }
        return ret;
    }
    
    private void dfs(TreeNode root, PriorityQueue<Pair> pair, int k, double target){
        if(root == null){
            return;
        }
        dfs(root.left, pair, k, target);
        pair.add(new Pair(Math.abs(target - root.val), root.val));
        if(pair.size() > k){
            pair.poll();
        }
        dfs(root.right, pair, k, target);
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