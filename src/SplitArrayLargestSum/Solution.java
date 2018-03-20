class Solution {
    public int splitArray(int[] nums, int m) {
        int max = 0;
        long sum = 0;
        for(int num: nums){
            max = Math.max(num, max);
            sum += num;
        }
        long low = max;
        long high = sum;
        while(low < high){
            long mid = low + (high - low) / 2;
            if(isMoreThanM(nums, mid, m)){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        return (int) low;
    }

    private boolean isMoreThanM(int[] nums, long target, int m){
        int count = 1;
        long total = 0;
        for(int num: nums){
            total += num;
            if(total > target){
                count ++;
                total = num;
                if(count > m){
                    return true;
                }
            }
        }
        return false;
    }
}