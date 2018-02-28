class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new int[]{};
        }
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            if(!hm.containsKey(nums[i])){
                hm.put(target - nums[i], i);
            }else{
                return new int[] {hm.get(nums[i]), i};
            }
        }

        return new int[]{};
    }
}