public class Solution {
    public int[] singleNumber(int[] nums) {
        int[] ret = new int[2];
        int mask = 0;
        for(int n : nums){
            mask ^= n;
        }
        
        int pos = 0;
        for(; pos < nums.length; pos++){
            if((mask & (1 << pos)) != 0){
                break;
            }
        }
        int a = 0; 
        int b = 0;
        for(int n : nums){
            if((n & (1 << pos)) != 0){
                a ^= n;
            }else{
                b ^= n;
            }
        }
        ret[0] = a;
        ret[1] = b;
        return ret;
    }
}