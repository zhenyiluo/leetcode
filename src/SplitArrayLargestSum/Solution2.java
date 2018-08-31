class Solution {
    public int splitArray(int[] nums, int m) {
        long sum = 0;
        long max = 0;
        for(int num : nums){
            sum += num;
            max = Math.max(num, max);
        }
        if(m == 1) return (int) sum;
        long left = max;
        long right = sum;
        while(left <= right){
            long mid = left + (right - left) /2;
            if(isValid(nums, mid, m)){
                right = mid -1;
            }else{
                left = mid + 1;
            }
        }
        return (int) left;
    }

    private boolean isValid(int[] nums, long mid, int m){
        int cnt = 1;
        long total = 0;
        for(int num: nums){
            total += num;
            if(total > mid){
                total = num;
                cnt ++;
                if(cnt > m){
                    return false;
                }
            }
        }
        return true;
    }
}