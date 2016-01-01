public class Solution {
    public void wiggleSort(int[] nums) {
        if(nums == null || nums.length <= 1){
            return;
        } 
        int[] sorted = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            sorted[i] = nums[i];
        }
        Arrays.sort(sorted);
        for (int i=nums.length-1, j=0, k=i/2+1; i>=0; i--)
        nums[i] = sorted[(i&1) != 0 ? k++ : j++];
    }
}