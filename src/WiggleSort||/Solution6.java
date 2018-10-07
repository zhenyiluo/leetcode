class Solution {
    public void wiggleSort(int[] nums) {
        if(nums == null || nums.length < 2) return;
        int n = nums.length;
        int medium = findKth(nums, n / 2);
        int i = 0;
        int left = 0;
        int right = n - 1;
        while(i <= right){
            if(nums[f(i, n)] > medium){
                swap(nums, f(i++, n), f(left++, n));
            }else if(nums[f(i, n)] < medium){
                swap(nums, f(i, n), f(right--, n));
            }else{
                i++;
            }
        }
    }

    private int f(int i, int n){
        return (1 + 2 * i) % (n | 1);
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private int findKth(int[] nums, int k){
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int p = partition(nums, start, end);
            if(p == k){
                return nums[p];
            }else if(p < k){
                start = p+1;
            }else{
                end = p - 1;
            }
        }
        return -1;
    }

    private int partition(int[] nums, int start, int end){
        int pivot = nums[start];
        int i = start;
        int j = end + 1;
        while(i < j){
            while(i < end && nums[++i] < pivot);
            while(j > start && nums[--j] > pivot);
            if(i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, start, j);
        return j;
    }
}