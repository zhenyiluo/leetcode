public class Solution {
    public List<String> findStrobogrammatic(int n) {
        List<String> ret = new ArrayList<String>();
        if(n <= 0){
            return ret;
        }
        
        if(n == 1){
            ret.add("0");
            ret.add("1");
            ret.add("8");
            return ret;
        }
        
        return dfs(0, n-1);
    }
    
    private List<String> dfs(int start, int end){
        List<String> list = new ArrayList<String>();
        if(start > end){
            list.add("");
            return list;
        }
        
        if(start == end){
            list.add("0");
            list.add("1");
            list.add("8");
            return list;
        }
        
        for(String s : dfs(start+1, end-1)){
            list.add("1" + s + "1");
            list.add("8" + s + "8");
            list.add("6" + s + "9");
            list.add("9" + s + "6");
            if(start != 0){
                list.add("0" + s + "0");
            }
        }
        return list;
    }
}