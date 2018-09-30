class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        HashSet<Integer> hs = new HashSet<>();
        for(int num: nums){
            hs.add(num);
        }
        int ans = 0;
        for(int num: hs){
            if(!hs.contains(num-1)){
                int cnt = 1;
                int cur = num;
                while(hs.contains(cur+1)){
                    cnt++;
                    cur++;
                }
                ans = Math.max(ans, cnt);
            }
        }
        return ans;
    }
}