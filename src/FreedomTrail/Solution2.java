class Solution {
    public int findRotateSteps(String ring, String key) {
        HashMap<Character, HashSet<Integer>> map = new HashMap<>();
        for(int i = 0; i < ring.length(); i++){
            char c = ring.charAt(i);
            if(!map.containsKey(c)){
                map.put(c, new HashSet<>());
            }
            map.get(c).add(i);
        }
        int n = ring.length();
        int[][] dp = new int[2][n];
        HashSet<Integer> hs = map.get(key.charAt(0));
        for(int pos: hs){
            dp[0][pos] = Math.min(pos, n - pos);
        }
        int m = key.length();
        for(int i= 1; i < m; i++){
            HashSet<Integer> prevPos = map.get(key.charAt(i-1));
            HashSet<Integer> curPos = map.get(key.charAt(i));
            for(int cur: curPos){
                int val = Integer.MAX_VALUE;
                for(int prev: prevPos){
                    int diff = Math.abs(prev - cur);
                    int step = Math.min(diff, n - diff);
                    val = Math.min(val, step + dp[(i-1) %2][prev]);
                }
                dp[i % 2][cur] = val;
            }
        }
        int ans = Integer.MAX_VALUE;
        HashSet<Integer> finalPos = map.get(key.charAt(m -1));
        for(int pos: finalPos){
            ans = Math.min(dp[(m-1) % 2][pos], ans);
        }
        return ans + m;
    }
}