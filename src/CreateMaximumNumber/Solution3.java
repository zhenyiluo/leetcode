class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        if(nums1 == null && nums2 == null) return new int[]{};
        if(k <= 0) return new int[]{};
        int m = nums1.length;
        int n = nums2.length;
        int[] ans = new int[]{};
        if(k > m + n){
            return new int[]{};
        }else if(k == m + n){
            return constructMaxNum(nums1, nums2);
        }else{
            for(int i = 0; i <= k; i++){
                int len1 = i;
                int len2 = k - i;
                if(len1 > m || len2 > n) continue;
                int[] tmp1 = findMaxSubArray(nums1, len1);
                int[] tmp2 = findMaxSubArray(nums2, len2);
                int[] tmp = constructMaxNum(tmp1, tmp2);
                if(compareTwoArr(ans, 0, tmp, 0) < 0){
                    ans = tmp;
                }
            }
        }
        return ans;
    }

    private int[] findMaxSubArray(int[] nums, int len){
        if(len == 0) return new int[]{};
        int cur = 0;
        int[] ans = new int[len];
        for(int i = 0; i < nums.length; i++){
            while(cur > 0 && nums.length - i > len - cur && ans[cur-1] < nums[i]){
                cur --;
            }
            if(cur < len){
                ans[cur++] = nums[i];
            }
        }
        return ans;
    }

    private int[] constructMaxNum(int[] nums1, int[] nums2){
        int m = nums1.length;
        int n = nums2.length;
        int[] ans = new int[m+n];
        int pos1 = 0;
        int pos2 = 0;
        int index = 0;
        while(index < m + n){
            if(compareTwoArr(nums1, pos1, nums2, pos2) < 0){
                ans[index++] = nums2[pos2++];
            }else{
                ans[index++] = nums1[pos1++];
            }
        }
        return ans;
    }

    private int compareTwoArr(int[] nums1, int s1, int[] nums2, int s2){
        int m = nums1.length - s1;
        int n = nums2.length - s2;
        int minLen = Math.min(m, n);
        for(int i = 0; i < minLen; i++){
            if(nums1[i+ s1] < nums2[i + s2]){
                return -1;
            }else if(nums1[i+s1] > nums2[i+s2]){
                return 1;
            }
        }
        return m - n;
    }
}