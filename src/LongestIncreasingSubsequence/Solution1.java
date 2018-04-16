class Solution1 {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] tails = new int[n];
        int size = 0;
        for(int num: nums){
            int i = 0;
            int j = size;
            while(i < j){
                int mid = i + (j - i) / 2;
                if(num > tails[mid]){
                    i = mid + 1;
                }else{
                    j = mid;
                }
            }
            tails[i] = num;
            if(i == size) size ++;
        }
        return size;
    }
}