public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        if(k <= 0 || k >9){
            return ret;
        }
        if(n < (1+k)*k/2){
            return ret;
        }
        if(n > (19-k) * k /2 ){
            return ret;
        }
        return dfs(k, n, 0);
    }
    
    private List<List<Integer>> dfs(int k, int n, int num){
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        if(k < 0 || n < 0){
            return ret;
        }
        if(k == 0 && n == 0){
            ret.add(new LinkedList<Integer>());
            return ret;
        }
        for(int i = num +1; i <=9; i++){
            for(List<Integer> list : dfs(k-1, n-i, i)){
                list.add(0, i);
                ret.add(list);
            }
        }
        
        return ret;
    }
}