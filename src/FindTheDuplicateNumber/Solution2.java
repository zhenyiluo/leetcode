public class Solution2 {
    public int findDuplicate(int[] nums) {
        int low = 1;
        int high = nums.length - 1;
        while(low <= high){
            int mid = low + ((high - low) >> 1);
            int count = 0;
            for(int val : nums){
                if(val <= mid){
                    count ++;
                }
            }
            
            if(count > mid){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
}