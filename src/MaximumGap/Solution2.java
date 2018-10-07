class Solution {
    public int maximumGap(int[] nums) {
        if(nums == null || nums.length <= 1) return 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int n = nums.length;
        for(int num: nums){
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        if(max == min) return 0;
        Bucket[] buckets = new Bucket[n];
        for(int num: nums){
            int index = (int)(1.0 * (num - min) / (max - min) * (n-1)) ;
            if(buckets[index] == null){
                buckets[index] = new Bucket(num, num);
            }else{
                buckets[index].min = Math.min(buckets[index].min, num);
                buckets[index].max = Math.max(buckets[index].max, num);
            }
        }
        int ans = 0;
        Integer prevMax = null;
        for(int i = 0; i < n; i++){
            if(buckets[i] != null){
                if(prevMax != null){
                    ans = Math.max(ans, buckets[i].min - prevMax);
                }
                prevMax = buckets[i].max;
            }
        }
        return ans;
    }
}

class Bucket{
    int min;
    int max;
    public Bucket(int min, int max){
        this.min = min;
        this.max = max;
    }
}