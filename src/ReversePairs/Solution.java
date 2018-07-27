class Solution {
    int[] tree;
    public int reversePairs(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int ret = 0;
        int[] copy = Arrays.copyOfRange(nums, 0, nums.length);
        Arrays.sort(copy);
        tree = new int[nums.length + 1];
        int count = 0;
        for(int num: nums){
            ret += count - query(index(copy, 2L * num + 1)-1);
            update(index(copy, num));
            count ++;
        }
        return ret;
    }

    private int index(int[] arr, long target){
        int left = 0;
        int right = arr.length -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(arr[mid] >= target){
                right = mid -1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

    private int query(int i){
        int ret = 0;
        for(int j = i + 1; j > 0; j -= j & (-j)){
            ret += tree[j];
        }
        return ret;
    }

    private void update(int i){
        for(int j = i + 1; j < tree.length; j += j & (-j)){
            tree[j] ++;
        }
    }
}