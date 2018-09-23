class Solution {
    public void wiggleSort(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int n = nums.length;
        int median = findKth(nums, n / 2);
        int left = 0;
        int right = n-1;
        int i = 0;
        while(i <= right){
            if(nums[f(i, n)] > median){
                swap(nums, f(i++, n), f(left++, n));
            }else if(nums[f(i, n)] < median){
                swap(nums, f(i, n), f(right--, n));
            }else{
                i++;
            }
        }
    }

    private int f(int idx, int n){
        return (1 + 2 * idx) % (n | 1);
    }

    private int findKth(int[] nums, int k){
        int n = nums.length;
        int start = 0;
        int end = n - 1;
        while(start <= end){
            int p = partition(nums, start, end);
            if(p == k) return nums[p];
            else if(p < k){
                start = p + 1;
            }else{
                end = p - 1;
            }
        }
        return -1;
    }

    private int partition(int[] nums, int start, int end){
        int pivot = nums[start];
        int l = start;
        int r = end + 1;
        while(l <= r){
            while(l < end && nums[++l] < pivot);
            while(r > start && nums[--r] > pivot);
            if(l >= r){
                break;
            }
            swap(nums, l, r);
        }
        swap(nums, start, r);
        return r;
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}