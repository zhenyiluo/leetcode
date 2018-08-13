class Solution {
    private int sum = 0;
    private HashMap<Integer, Integer> hm = new HashMap<>();
    public int pathSum(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        for(int num: nums){
            int key = num / 10;
            int val = num % 10;
            hm.put(key, val);
        }

        dfs(nums[0] / 10, 0);
        return sum;
    }

    private void dfs(int root, int preSum){
        int pos = root % 10;
        int level = root / 10;
        int left = (level + 1) * 10 + pos * 2 -1;
        int right = (level + 1) * 10 + pos * 2;
        int curSum = preSum + hm.get(root);
        if(!hm.containsKey(left) && !hm.containsKey(right)){
            sum += curSum;
        }
        if(hm.containsKey(left)) dfs(left, curSum);
        if(hm.containsKey(right)) dfs(right, curSum);
    }
}