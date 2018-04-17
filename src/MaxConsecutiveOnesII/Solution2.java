class Solution2 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        Queue<Integer> zeroIndex = new LinkedList<>();
        int k = 1;
        for(int low = 0, high = 0; high < nums.length; high++){
            if(nums[high] == 0){
                zeroIndex.add(high);
            }
            while(zeroIndex.size() > k){
                low = zeroIndex.poll() + 1;
            }
            max = Math.max(max, high - low + 1);
        }
        return max;
    }
}