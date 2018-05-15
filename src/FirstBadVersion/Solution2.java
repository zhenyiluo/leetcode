/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution2 extends VersionControl {
    public int firstBadVersion(int n) {
        int ans = 0;
        int left = 1;
        int right = n;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(isBadVersion(mid)){
                ans = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return ans;
    }
}