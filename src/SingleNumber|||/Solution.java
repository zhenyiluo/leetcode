public class Solution {
    public int[] singleNumber(int[] nums) {
        int[] ret = new int[2];
        HashSet<Integer> hs = new HashSet<Integer>();
        for(int n : nums){
            if(hs.contains(n)){
                hs.remove(n);
            }else{
                hs.add(n);
            }
        }
        int index = 0;
        for(int n : hs){
            ret[index++] = n;
        }
        return ret;
    }
}