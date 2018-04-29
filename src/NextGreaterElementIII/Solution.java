class Solution {
    public int nextGreaterElement(int n) {
        if(n == 0) return -1;
        ArrayList<Integer> list = new ArrayList<>();
        while(n != 0){
            list.add(0, n % 10);
            n /= 10;
        }
        int[] nums = new int[list.size()];
        for(int i = 0; i < nums.length; i++){
            nums[i] = list.get(i);
        }
        if(!nextPermutation(nums)) return -1;
        long ret = 0;
        for(int i = 0; i < nums.length; i++){
            ret = ret * 10 + nums[i];
        }
        if(ret > Integer.MAX_VALUE) return -1;
        return (int) ret;
    }

    public boolean nextPermutation(int[] nums) {

        int len = nums.length;
        int posLeft = -1;
        for(int i = len -1; i >= 1; i --){
            if(nums[i-1] < nums[i]){
                posLeft = i-1;
                break;
            }
        }
        if(posLeft == -1){
            return false;
        }
        int posRight = findFirstNumberLarger(nums[posLeft], posLeft+1, len-1, nums);
        swap(nums, posLeft, posRight);
        Arrays.sort(nums, posLeft+1, len);
        return true;
    }

    private int findFirstNumberLarger(int target, int start, int end, int[] nums){
        for(int i = end; i >= start; i--){
            if(nums[i] > target){
                return i;
            }
        }
        return -1;
    }

    private void swap(int[] nums, int l, int r){
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }
}