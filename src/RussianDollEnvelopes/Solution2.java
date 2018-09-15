class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0 || envelopes[0].length == 0) return 0;
        int n = envelopes.length;
        Arrays.sort(envelopes, (a, b) -> (a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]));
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = envelopes[i][1];
        }
        return lengthOfLIS(nums);
    }

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