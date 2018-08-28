class Solution {
    public int majorityElement(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        boolean hasMajority = false;
        int ans = 0;
        int cnt = 0;
        for(int num: nums){
            if(!hasMajority){
                hasMajority = true;
                ans = num;
                cnt ++;
            }else{
                if(ans == num){
                    cnt ++;
                }else{
                    cnt --;
                    if(cnt == 0){
                        hasMajority = false;
                    }
                }
            }
        }
        return ans;
    }
}