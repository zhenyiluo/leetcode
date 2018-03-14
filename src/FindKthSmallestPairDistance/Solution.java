class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        int[] diff = new int[1000000];
        for(int i = 0; i < nums.length -1; i++){
            for(int j = i+1; j < nums.length; j++){
                diff[Math.abs(nums[i]-nums[j])] ++;
            }
        }
        int sum = 0;
        for(int i = 0; i < 1000000; i++){
            sum += diff[i];
            if(sum >= k){
                return i;
            }
        }
        return -1;
    }
}