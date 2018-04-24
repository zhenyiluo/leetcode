class Solution {
    public List<String> findStrobogrammatic(int n) {
        if(n <= 0){
            return new ArrayList<>();
        }

        return dfs(n, n);
    }

    private List<String> dfs(int len, int remain){
        List<String> ret = new ArrayList<>();
        if(remain == 0){
            ret.add("");
            return ret;
        }

        if(remain == 1){
            ret.add("0");
            ret.add("1");
            ret.add("8");
            return ret;
        }

        for(String next : dfs(len, remain - 2)){
            ret.add("1" + next + "1");
            ret.add("6" + next + "9");
            ret.add("9" + next + "6");
            ret.add("8" + next + "8");
            if(len != remain){
                ret.add("0" + next + "0");
            }
        }
        return ret;
    }
}