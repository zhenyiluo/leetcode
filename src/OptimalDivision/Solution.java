class Solution {
    public String optimalDivision(int[] nums) {
        if(nums.length == 1) return String.valueOf(nums[0]);
        if(nums.length == 2) return String.valueOf(nums[0]) + "/" + String.valueOf(nums[1]);
        StringBuilder ret = new StringBuilder();
        ret.append(nums[0]);
        ret.append("/(");
        ret.append(nums[1]);
        for(int i = 2; i < nums.length; i++){
            ret.append("/");
            ret.append(nums[i]);
        }
        ret.append(")");
        return ret.toString();
    }
}