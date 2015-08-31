import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args){
        int[] nums = new int[]{-1};
        System.out.println(new Solution().summaryRanges(nums));
    }
    public List<String> summaryRanges(int[] nums) {
        List<String> ret = new LinkedList<String>();
        if(nums == null || nums.length == 0){
            return ret;
        }
        int index = 0;
        boolean flag = false;
        int first = -1;
        int prev = -1;
        int cur = -1;
        while(index < nums.length){
            if(!flag){
                first = nums[index];
                prev = first;
                flag = true;
            }else{
                cur = nums[index];
                if(cur != prev +1){
                    if(first != prev){
                        ret.add(first + "->" + prev); 
                    }else{
                        ret.add("" + first);
                    }
                    first = cur;
                }
                prev = cur;
            }
            index++;
        }
        if(first != prev){
            ret.add(first + "->" + prev); 
        }else{
            ret.add("" + first);
        }
        return ret;
    }
}