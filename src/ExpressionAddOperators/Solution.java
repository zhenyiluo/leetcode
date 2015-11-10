public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> ret = new LinkedList<String>();
        if(num == null || num.length() == 0){
            return ret;
        }
        dfs(ret, num, target, "", 0, 0, 0);
        return ret;
    }
    
    private void dfs(List<String> ret, String num, int target, String path, int pos, long sum, long prev){
        if(pos == num.length()){
            if(sum == target){
                ret.add(path);
            }
        }else{
            for(int i = pos; i < num.length(); i++){
                if(i != pos && num.charAt(pos) == '0'){
                    break;
                }
                long cur = Long.parseLong(num.substring(pos, i+1));
                if(pos == 0){
                    dfs(ret, num, target, path + cur, i+1, cur, cur);
                }else{
                    dfs(ret, num, target, path + "+" + cur, i+1, sum + cur, cur);
                    dfs(ret, num, target, path + "-" + cur, i+1, sum - cur, -cur);
                    dfs(ret, num, target, path + "*" + cur, i+1, sum - prev + prev * cur, prev * cur);
                }
            }
        }
    }
}