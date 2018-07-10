class Solution {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length <= 1){
            return;
        }
        k = k % nums.length;
        if(k == 0){
            return;
        }
        int[] copyNums = new int[nums.length];
        System.arraycopy(nums, 0, copyNums, 0, nums.length);
        for(int i = 0; i < nums.length; i++){
            nums[(i + k) % nums.length] = copyNums[i];
        }
    }
}