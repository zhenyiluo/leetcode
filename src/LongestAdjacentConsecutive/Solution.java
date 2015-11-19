public class Solution {
    public static void main(String[] args){
        int[] nums1 = {6, 1, 2, 5, 3};
        int[] nums2 = {6, 1, 2, 3, 5};
        int[] nums3 = {5, 6, 4, 3, 2};
        System.out.println(new Solution().getLongestAdjacentConsecutive(nums1));
        System.out.println(new Solution().getLongestAdjacentConsecutive(nums2));
        System.out.println(new Solution().getLongestAdjacentConsecutive(nums3));
    }
    public int getLongestAdjacentConsecutive(int[] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }

        int len = nums.length;
        if(len == 1){
            return 1;
        }

        int ret = 1;

        int[] dp1 = new int[len];
        int[] dp2 = new int[len];

        dp1[0] = 1;
        dp2[0] = 1;
        for(int i = 1; i < len; i++){
            dp1[i] = nums[i] == nums[i-1] + 1 ? dp1[i-1] + 1 : 1;
            dp2[i] = nums[i] == nums[i-1] - 1 ? dp2[i-1] + 1 : 1;

            ret = Math.max(ret, Math.max(dp1[i], dp2[i]));
        }

        return ret;
    }
}

