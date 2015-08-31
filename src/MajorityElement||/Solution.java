public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ret = new LinkedList<Integer>();
        if(nums == null || nums.length == 0){
            return ret;
        }
        int m1 = 0;
        int m2 = 0;
        int c1 = 0;
        int c2 = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == m1){
                c1++;
            }else if(nums[i] == m2){
                c2++;
            }else if(c1 == 0){
                c1 = 1;
                m1 = nums[i];
            }else if(c2 == 0){
                c2 = 1;
                m2 = nums[i];
            }else{
                c1 --;
                c2 --;
            }
        }
        int count1 = 0;
        int count2 = 0;
        for(int i = 0; i < nums.length; i++){
            if(m1 == nums[i]){
                count1++;
            }else if(m2 == nums[i]){
                count2++;
            }
        }
        if(count1 > nums.length /3){
            ret.add(m1);
        }
        if(count2 > nums.length / 3){
            ret.add(m2);
        }
        return ret;
    }
}