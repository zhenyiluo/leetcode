class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length -1;
        int ret = 0;
        while(left < right){
            int hLeft = height[left];
            int hRight = height[right];
            ret = Math.max(ret, (right - left) * Math.min(hLeft, hRight));
            if(hLeft < hRight){
                left ++;
            }else{
                right --;
            }
        }
        return ret;
    }
}