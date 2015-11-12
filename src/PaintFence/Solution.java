public class Solution {
    public int numWays(int n, int k) {
        if(n <= 0 || k <= 0){
            return 0;
        }
        
        int preSame = 0;
        int preDiff = k;
        
        for(int i = 1; i < n; i++){
            int same = preDiff;
            int diff = (k-1) * (preSame + preDiff);
            
            preSame = same;
            preDiff = diff;
        }
        
        return preSame + preDiff;
    }
}