public class Solution {
    public void wiggleSort(int[] nums) {
        if(nums == null || nums.length <= 1){
            return;
        }
        
        Arrays.sort(nums);
        int len = nums.length;
        int ps = 0;
        int pl = (len +1) / 2;
        int index = 0;
        while(ps < len && pl < len && index < len){
            if(index == ps){
                ps += 2;
            }else{
                swap(nums, index, pl);
                pl ++;
            }
            index++;
        }
    }
    
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}