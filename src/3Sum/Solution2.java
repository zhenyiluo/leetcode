class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length < 3){
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<List<Integer>> hs = new HashSet<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length -2; i++){
            int j = i + 1;
            int k = nums.length -1;
            while(j < k){
                long sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    if(!hs.contains(list)){
                        hs.add(list);
                        ans.add(list);
                    }
                    j ++;
                    k --;
                }else if(sum < 0){
                    j++;
                }else{
                    k --;
                }
            }
        }
        return ans;
    }
}