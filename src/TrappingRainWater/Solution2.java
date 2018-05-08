class Solution {
    public int trap(int[] height) {
        if(height == null || height.length <= 1) return 0;
        int ret = 0;
        int i = 0;
        int j = height.length -1;
        int level = 0;
        while(i < j){
            level = Math.min(height[i], height[j]) > level ? Math.min(height[i], height[j]) : level;
            ret += height[i] < height[j] ? level - height[i++] : level - height[j--];
        }
        return ret;
    }
}