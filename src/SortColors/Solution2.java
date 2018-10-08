class Solution {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length <= 1) return;
        int cnt0 = 0;
        int cnt1 = 0;
        int cnt2 = 0;
        for(int num: nums){
            if(num == 0){
                cnt0 ++;
            }else if(num == 1){
                cnt1 ++;
            }else if(num == 2){
                cnt2++;
            }
        }
        int index = 0;
        for(int i = 0; i < cnt0; i++){
            nums[index++] = 0;
        }
        for(int i = 0; i < cnt1; i++){
            nums[index++] = 1;
        }
        for(int i = 0; i < cnt2; i++){
            nums[index++] = 2;
        }
    }
}