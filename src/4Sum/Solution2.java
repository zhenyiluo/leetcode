class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums == null || nums.length < 4) return ans;
        HashSet<List<Integer>> hs = new HashSet<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0; i < n - 3; i++){
            for(int j = i+1; j < n-2; j++){
                int k = j + 1;
                int l = n - 1;
                while(k < l){
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if(sum == target){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(nums[l]);
                        if(!hs.contains(list)){
                            hs.add(list);
                            ans.add(list);
                        }
                        k ++;
                        l --;
                    }else if(sum < target){
                        k ++;
                    }else{
                        l --;
                    }
                }
            }
        }
        return ans;
    }
}