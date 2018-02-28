class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        HashSet<List<Integer>> hs = new HashSet<>();
        if(nums == null || nums.length < 4) {
            return ret;
        }

        Arrays.sort(nums);
        int len = nums.length;
        int k, p, sum;
        for(int i = 0; i < len -3; i++){
            for(int j = i+1; j < len -2; j++) {
                k = j+1;
                p = len -1;
                while(k < p){
                    sum = nums[i] + nums[j] + nums[k] + nums[p];
                    if(sum == target) {
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[k]);
                        tmp.add(nums[p]);
                        if(!hs.contains(tmp)){
                            hs.add(tmp);
                            ret.add(tmp);
                        }
                        k++;
                        p--;
                    }else if(sum < target) {
                        k++;
                    }else{
                        p--;
                    }
                }

            }
        }
        return ret;
    }
}