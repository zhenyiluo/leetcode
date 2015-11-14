public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> ret = new ArrayList<>();
        if(n <= 3){
            return ret;
        }
        ret = new ArrayList<>(dfs(n, n));
        return ret;
    }
    
    private HashSet<List<Integer>> dfs(int val, int n){
        HashSet<List<Integer>> ret = new HashSet<>();
        if(val != n){
            List<Integer> list = new ArrayList<>();
            list.add(val);
            ret.add(list);
        }
        
        for(int i = 2; i * i <= val; i++){
            if(val % i == 0){
                for(List<Integer> list : dfs(val / i, n)){
                    list.add(0, i);
                    Collections.sort(list);
                    ret.add(list);
                }
            }
        }
        return ret;
    }
}