class Solution {
    Random random = new Random();
    public static void main(String[] args) {
        int[] nums = new int[]{6,5,4,3,2,1, 12, 543, 32};
        Solution sol = new Solution();
        sol.quickSort(nums, 0, nums.length-1);
        for (int num : nums) {
            System.out.println(num + ", ");
        }
    }

    public void quickSort(int[] nums, int start, int end) {
        if(start >= end) return;
        int p = partition(nums, start, end);
        quickSort(nums, start, p-1);
        quickSort(nums, p+1, end);
    }

    private int partition(int[] nums, int start, int end){
        int rand = start + random.nextInt(end - start + 1);
        swap(nums, start, rand);
        int pivot = nums[start];
        int l = start;
        int r = end + 1;
        while(l < r){
            while(l < end && nums[++l] < pivot);
            while(r > start && nums[--r] > pivot);
            if(l >= r) break;
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