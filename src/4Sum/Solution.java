class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<List<Integer>> hs = new HashSet<>();
        if(nums == null || nums.length < 4) return ans;
        int len = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < len -3; i++){
            for(int j = i+1; j < len -2; j++){
                int k = j + 1;
                int l = len -1;
                while(k < l){
                    long sum = nums[i] + nums[j] + nums[k] + nums[l];
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
                        k++;
                        l--;
                    }else if(sum < target){
                        k++;
                    }else{
                        l--;
                    }
                }
            }
        }
        return ans;
    }
}