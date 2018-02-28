class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        HashSet<List<Integer>> hs = new HashSet<>();
        if (nums == null || nums.length <3){
            return ret;
        }

        Arrays.sort(nums);

        for(int i = 0; i < nums.length -2; i++){
            int j = i +1;
            int k = nums.length -1;
            int sum;
            while(j < k){
                sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    if(!hs.contains(temp)) {
                        hs.add(temp);
                        ret.add(temp);
                    }
                    j++;
                    k--;

                }else if(sum < 0){
                    j++;
                }else{
                    k--;
                }
            }
        }
        return ret;
    }
}