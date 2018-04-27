class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if(nums == null || nums.length == 0){
            return new int[0];
        }
        int n = nums.length;
        int[] ret = new int[n];
        if(a == 0){
            for(int i = 0; i < n; i++){
                int cur = b >= 0 ? nums[i] : nums[n - i -1];
                ret[i] = b * cur + c;
            }
            return ret;
        }

        double pivot = -1.0 * b / (2 * a);
        int[] distSort = new int[n];
        int start = 0;
        int end = n-1;
        int idx = n-1;
        while(start <= end){
            double d1 = pivot - nums[start];
            double d2 = nums[end] - pivot;
            if(d1 > d2){
                distSort[idx--] = nums[start ++];
            }else{
                distSort[idx--] = nums[end --];
            }
        }

        for(int i = 0; i < n; i++){
            int cur = a >= 0 ? distSort[i] : distSort[n - i -1];
            ret[i] = a * cur * cur + b * cur + c;
        }
        return ret;
    }
}