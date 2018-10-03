class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        HashSet<Integer> hs = new HashSet<>();
        for(int num: nums){
            hs.add(num);
        }
        int ans = 0;
        for(int n: hs){
            if(!hs.contains(n-1)){
                int tmp = 1;
                while(hs.contains(++n)){
                    tmp++;
                }
                ans = Math.max(ans, tmp);
            }
        }
        return ans;
    }
}