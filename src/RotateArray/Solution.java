public class Solution {
    public void rotate(int[] nums, int k) {
        if(nums == null){
            return;
        }
        int len = nums.length;
        if(k % len == 0){
            return;
        }
        
        k %= len;
        int len1 = len - k;
        
        reverse(nums, 0, len1 -1);
        reverse(nums, len1, len -1);
        reverse(nums, 0, len -1);
    }
    
    private void reverse(int[] nums, int start, int end){
        while(start < end){
            swap(nums, start, end);
            start ++;
            end--;
        }
    }
    
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}