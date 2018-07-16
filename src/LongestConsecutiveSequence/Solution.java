class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        HashSet<Integer> hs = new HashSet<>();
        for(int num: nums){
            hs.add(num);
        }
        int ret = 0;
        for(int num: hs){
            if(!hs.contains(num-1)){
                int curNum = num;
                int curLen = 1;
                while(hs.contains(curNum+1)){
                    curNum ++;
                    curLen ++;
                }
                ret = Math.max(ret, curLen);
            }
        }
        return ret;
    }
}