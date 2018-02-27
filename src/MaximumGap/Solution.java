
class Solution {
    class Bucket  {
        int low;
        int high;
        public Bucket(){
            low = -1;
            high = -1;
        }
    }
    public int maximumGap(int[] nums) {
        if(nums == null || nums.length < 2) return 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        Bucket[] buckets = new Bucket[nums.length +1];
        for(int i = 0; i < nums.length +1; i++){
            buckets[i] = new Bucket();
        }
        double interval = (double) nums.length / (max - min);
        for(int i = 0; i < nums.length; i++){
            int index = (int) (interval * (nums[i] - min));
            if(buckets[index].low == -1){
                buckets[index].low = nums[i];
                buckets[index].high = nums[i];
            }else{
                buckets[index].low = Math.min(buckets[index].low, nums[i]);
                buckets[index].high = Math.max(buckets[index].high, nums[i]);
            }
        }
        int ret = 0;
        int prev = buckets[0].high;
        for(int i = 1; i < buckets.length; i++){
            if(buckets[i].low != -1){
                ret = Math.max(ret, buckets[i].low - prev);
                prev = buckets[i].high;
            }
        }
        return ret;
    }
}