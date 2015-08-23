public class Solution {
    public void rotate(int[] nums, int k) {
        if(nums == null){
            return;
        }
        int n = nums.length;
        if(k % n == 0){
            return;
        }
        
        int[] tmp = Arrays.copyOf(nums, n);
        if(k > n){
            k %= n;
        }
        int index = 0;
        for(int i = n-k; ; i++, index ++){
            nums[index] = tmp[i% n];
            if(i % n == n -k -1){
                break;
            }
        }
    }
}