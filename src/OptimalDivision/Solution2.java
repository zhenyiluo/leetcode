class Solution2 {
    public String optimalDivision(int[] nums) {
        return getMax(0, nums.length -1, nums).str;
    }

    private Element getMax(int start, int end, int[] nums){
        Element e = new Element();
        e.val = Double.MIN_VALUE;
        if(start == end){
            e.str = String.valueOf(nums[start]);
            e.val = Double.valueOf(nums[start]);
        }else if(start +1 == end){
            e.str = String.valueOf(nums[start]) + "/" + String.valueOf(nums[end]);
            e.val = Double.valueOf(nums[start]) / Double.valueOf(nums[end]);
        }else{
            for(int i = start; i < end; i++){
                Element e1 = getMax(start, i, nums);
                Element e2 = getMin(i+1, end, nums);
                if((e1.val/e2.val) > e.val){
                    e.str = e1.str + "/" + ((end - i >= 2) ? "(" + e2.str + ")" : e2.str);
                    e.val = e1.val / e2.val;
                }
            }
        }
        return e;
    }

    private Element getMin(int start, int end, int[] nums){
        Element e = new Element();
        e.val = Double.MAX_VALUE;
        if(start == end){
            e.str = String.valueOf(nums[start]);
            e.val = Double.valueOf(nums[start]);
        }else if(start +1 == end){
            e.str = String.valueOf(nums[start]) + "/" + String.valueOf(nums[end]);
            e.val = Double.valueOf(nums[start]) / Double.valueOf(nums[end]);
        }else{
            for(int i = start; i < end; i++){
                Element e1 = getMin(start, i, nums);
                Element e2 = getMax(i+1, end, nums);
                if((e1.val/e2.val) < e.val){
                    e.str = e1.str + "/" + ((end - i >= 2) ? "(" + e2.str + ")" : e2.str);
                    e.val = e1.val / e2.val;
                }
            }
        }
        return e;
    }
}

class Element{
    String str;
    double val;
}