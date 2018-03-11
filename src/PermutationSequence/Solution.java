class Solution {
    public String getPermutation(int n, int k) {
        if(n < 0 || n > 9) return "";
        if(k < 0 || k > fact(n)) return "";
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            list.add(i);
        }
        dfs(sb, list, n, k);
        return sb.toString();
    }

    private void dfs(StringBuilder sb, List<Integer> list, int n, int k){
        if(list.size() == 0){
            return;
        }
        int base = fact(n-1);
        int index = (k-1)/ base;
        sb.append(list.remove(index));
        dfs(sb, list, n -1, k - base * index);
    }

    private int fact(int n){
        if(n == 0 || n == 1){
            return 1;
        }
        return n * fact(n-1);
    }
}