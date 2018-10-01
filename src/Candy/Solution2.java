class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] val = new int[n];
        Arrays.fill(val, 1);
        for(int i = 1; i < n; i++){
            if(ratings[i] > ratings[i-1]) val[i] = val[i-1] + 1;
        }
        for(int i = n-2; i >= 0; i--){
            if(ratings[i] > ratings[i+1]) val[i] = Math.max(val[i], val[i+1] + 1);
        }
        int sum = 0;
        for(int v : val){
            sum += v;
        }
        return sum;
    }
}