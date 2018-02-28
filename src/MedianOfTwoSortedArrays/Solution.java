class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int l = (m + n + 1) / 2;
        int r = (m + n + 2) / 2;
        return (getKth(nums1, 0, nums2, 0, l) + getKth(nums1, 0, nums2, 0, r)) * 0.5;
    }

    private double getKth(int[] a, int aStart, int[] b, int bStart, int k){
        if(aStart >= a.length) return b[bStart + k -1];
        if(bStart >= b.length) return a[aStart + k -1];
        if(k == 1) return Math.min(a[aStart], b[bStart]);
        int mid1 = Integer.MAX_VALUE;
        int mid2 = Integer.MAX_VALUE;
        if(aStart + k/2 -1 < a.length) mid1 = a[aStart + k/2 -1];
        if(bStart + k/2 -1 < b.length) mid2 = b[bStart + k/2 -1];
        if(mid1 > mid2){
            return getKth(a, aStart, b, bStart + k/2, k - k/2);
        }else{
            return getKth(a, aStart + k/2, b, bStart, k - k/2);
        }
    }
}