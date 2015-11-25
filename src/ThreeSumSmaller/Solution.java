public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if(nums == null || nums.length <3){
            return 0;
        }
        
        int len = nums.length;
        int ret = 0;
        
        Arrays.sort(nums);
        
        for(int first = 0; first < len-2; first++){
            int left = first + 1;
            int right = len - 1;
            while(left < right){
                int sum = nums[first] + nums[left] + nums[right];
                if(sum < target){
                    ret += right - left;
                    left ++;
                }else{
                    right --;
                }
            }
        }
        
        return ret;
    }
}