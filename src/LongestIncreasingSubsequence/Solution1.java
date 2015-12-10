public class Solution1 {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        if(nums.length == 1){
            return 1;
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int n : nums){
            if(list.size() == 0 || n > list.get(list.size() - 1)){
                list.add(n);
            }else{
                int index = helper(list, n);
                list.set(index, n);
            }
        }
        return list.size();
    }
    
    private int helper(ArrayList<Integer> list, int n){
        int low = 0; 
        int high = list.size() - 1;
        while(low <= high){
            int mid = low + ((high - low)>> 1);
            if(list.get(mid) == n){
                return mid;
            }else if(list.get(mid) < n){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return low;
    }
}