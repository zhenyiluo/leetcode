class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] ans = new int[k];
        int m = nums1.length;
        int n = nums2.length;
        if(k > m + n) return ans;
        if(k == m + n) return merge(nums1, nums2, k);
        for(int i = 0; i <= k; i++){
            if(i > nums1.length || k-i > nums2.length) continue;
            int[] max1 = maxSubArray(nums1, i);
            int[] max2 = maxSubArray(nums2, k - i);
            int[] tmp = merge(max1, max2, k);
            if(compare(ans, 0, tmp, 0) < 0){
                ans = tmp;
            }
        }
        return ans;
    }

    private int[] merge(int[] nums1, int[] nums2, int k){
        int[] ans = new int[k];
        int idx = 0;
        int start1 = 0;
        int start2 = 0;
        while(idx < k){
            if(compare(nums1, start1, nums2, start2) < 0){
                ans[idx++] = nums2[start2++];
            }else {
                ans[idx++] = nums1[start1++];
            }
        }
        return ans;
    }

    private int[] maxSubArray(int[] nums, int k){
        int[] ans = new int[k];
        int idx = 0;
        for(int i = 0; i < nums.length; i++){
            while(idx > 0 && idx + nums.length - i > k && ans[idx-1] < nums[i]){
                idx --;
            }
            if(idx < k){
                ans[idx++] = nums[i];
            }
        }
        return ans;
    }

    private int compare(int[] nums1, int start1, int[] nums2, int start2){
        int len1 = nums1.length - start1;
        int len2 = nums2.length - start2;
        int minLen = Math.min(len1, len2);
        for(int i = 0; i < minLen; i++){
            if(nums1[i + start1] < nums2[i + start2]){
                return -1;
            }else if(nums1[i + start1] > nums2[i + start2]){
                return 1;
            }
        }
        return len1 - len2;
    }
}