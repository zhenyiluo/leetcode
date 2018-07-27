class Solution {
    int[] tree;
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        if(nums == null || nums.length == 0) return ret;
        int[] copy = Arrays.copyOfRange(nums, 0, nums.length);
        Arrays.sort(copy);
        tree = new int[nums.length + 1];
        for(int i = nums.length -1; i >= 0; i--){
            ret.add(0, query(index(copy, nums[i]) -1));
            update(index(copy, nums[i]));
        }
        return ret;
    }

    private int index(int[] arr, int num){
        int left = 0;
        int right = arr.length -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(arr[mid] >= num){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

    private int query(int i){
        int ret = 0;
        for(int j = i+1; j > 0; j -= j & (-j)){
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