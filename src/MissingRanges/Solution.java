class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        long lowerL = lower;
        long upperL = upper;
        if(lowerL > upperL) return new ArrayList<>();
        List<String> ret = new ArrayList<>();
        if(nums == null || nums.length == 0){
            ret.add(generateString(lowerL, upperL));
            return ret;
        }
        for(int num: nums){
            if(num < lowerL) continue;
            if(num == lowerL){
                lowerL ++;
            }else{
                if(num <= upperL){
                    ret.add(generateString(lowerL, num -1));
                    lowerL = (long) num + 1;
                }else{
                    ret.add(generateString(lowerL, upperL));
                    break;
                }
            }
            if(lowerL > upperL) break;
        }
        if(lowerL <= upperL){
            ret.add(generateString(lowerL, upperL));
        }
        return ret;
    }

    private String generateString(long lower, long upper){
        if(lower == upper){
            return String.valueOf(lower);
        }
        return lower + "->" + upper;
    }
}