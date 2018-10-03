class Solution {
    public int trap(int[] height) {
        if(height == null || height.length <= 2) return 0;
        int left = 0;
        int right = height.length -1;
        int ceil = 0;
        int ans = 0;
        while(left < right){
            ceil = Math.max(ceil, Math.min(height[left], height[right]));
            if(height[left] < height[right]){
                ans += ceil - height[left++];
            }else{
                ans += ceil - height[right--];
            }
        }
        return ans;
    }
}