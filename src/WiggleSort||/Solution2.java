class Solution {
    public void wiggleSort(int[] nums) {
        int median = findKthLargest(nums, nums.length / 2);
        int n = nums.length;
        int left = 0, i = 0, right = n - 1;
        while (i <= right) {
            if (nums[newIndex(i,n)] > median) {
                swap(nums, newIndex(left++,n), newIndex(i++,n));
            }
            else if (nums[newIndex(i,n)] < median) {
                swap(nums, newIndex(right--,n), newIndex(i,n));
            }
            else {
                i++;
            }
        }
    }

    private int newIndex(int index, int n) {
        return (1 + 2*index) % (n | 1);
    }

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