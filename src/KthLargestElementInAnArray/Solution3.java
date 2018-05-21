class Solution {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int left = 0;
        int right = nums.length -1;
        while(left < right){
            int p = partition(nums, left, right);
            if(p < k){
                left = p + 1;
            }else if(p > k){
                right = p - 1;
            }else{
                break;
            }
        }
        return nums[k];
    }

    private int partition(int[] nums, int left, int right){
        int pivot = nums[left];
        int i = left;
        int j = right + 1;
        while(true){
            while(i < right && nums[++i] < pivot);
            while(j > left && nums[--j] > pivot);
            if(i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, left, j);
        return j;
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}