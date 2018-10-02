class Solution {
    Random rand = new Random();
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0) return -1;
        int len = nums.length;
        k = len - k;
        int left = 0;
        int right = len -1;
        while(left <= right){
            int pivot = partition(nums, left, right);
            if(pivot == k){
                return nums[k];
            }else if(pivot < k){
                left = pivot + 1;
            }else{
                right = pivot - 1;
            }
        }
        return -1;
    }

    private int partition(int[] nums, int left, int right){
        int random = left + rand.nextInt(right - left + 1);
        swap(nums, random, left);
        int pivot = nums[left];
        int l = left;
        int r = right + 1;
        while(l <= r){
            while(l < right && nums[++l] < pivot);
            while(r > left && nums[--r] > pivot);
            if(l >= r) break;
            swap(nums, l, r);
        }
        swap(nums, left, r);
        return r;
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
