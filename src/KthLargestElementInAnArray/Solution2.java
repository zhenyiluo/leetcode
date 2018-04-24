class Solution2 {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int low = 0;
        int high = nums.length - 1;
        while(low < high){
            int p = partition(nums, low, high);
            if(p < k){
                low = p + 1;
            }else if(p > k){
                high = p - 1;
            }else{
                break;
            }
        }
        return nums[k];
    }

    private int partition(int[] nums, int low, int high){
        int pivot = nums[low];
        int i = low;
        int j = high + 1;
        while(true){
            while(i < high && nums[++i] < pivot);
            while(j > low && nums[--j] > pivot);
            if(i >= j){
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, low, j);
        return j;
    }

    private void swap(int[] nums, int x, int y){
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }
}