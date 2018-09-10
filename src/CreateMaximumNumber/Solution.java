class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] ans = new int[k];
        int len1 = nums1.length;
        int len2 = nums2.length;
        if(len1 + len2 < k) return ans;
        if(len1 + len2 == k) return mergeTwoArrays(nums1, nums2, k);
        for(int i = 0; i <= k; i++){
            if(i > nums1.length || k - i > nums2.length) continue;
            int[] max1 = maxSubarray(nums1, i);
            int[] max2 = maxSubarray(nums2, k - i);
            int[] tmp = mergeTwoArrays(max1, max2, k);
            if(compare(ans, 0, tmp, 0) < 0) ans = tmp;
        }
        return ans;
    }

    private int[] mergeTwoArrays(int[] nums1, int[] nums2, int k){
        int[] ret = new int[k];
        int idx1 = 0;
        int idx2 = 0;
        int idx = 0;
        while(idx < k){
            if(compare(nums1, idx1, nums2, idx2) < 0){
                ret[idx++] = nums2[idx2++];
            }else{
                ret[idx++] = nums1[idx1++];
            }
        }
        return ret;
    }

    private int[] maxSubarray(int[] nums, int k){
        int[] ret = new int[k];
        int len = 0;
        for(int i = 0; i < nums.length; i++){
            while(len > 0 && len + nums.length - i > k && ret[len-1] < nums[i]){
                len --;
            }
            if(len < k){
                ret[len++] = nums[i];
            }
        }
        return ret;
    }

    private int compare(int[] nums1, int start1, int[] nums2, int start2){
        int len1 = nums1.length - start1;
        int len2 = nums2.length - start2;
        int minLen = Math.min(len1, len2);
        for(int i = 0; i < minLen; i++){
            if(nums1[start1 + i] == nums2[start2 + i]) continue;
            if(nums1[start1 + i] < nums2[start2 + i]){
                return -1;
            }else{
                return 1;
            }
        }
        return len1 - len2;
    }
}