class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] val = new int[n];
        int cnt = 1;
        for(int i = 1; i < n; i++){
            if(ratings[i] > ratings[i-1]){
                val[i] = Math.max(val[i], cnt++);
            }else{
                cnt = 1;
            }
        }
        cnt = 1;
        for(int i = n-2; i >= 0; i --){
            if(ratings[i] > ratings[i+1]){
                val[i] = Math.max(val[i], cnt++);
            }else{
                cnt = 1;
            }
        }
        int ans = n;
        for(int v : val){
            ans += v;
        }
        return ans;
    }
}