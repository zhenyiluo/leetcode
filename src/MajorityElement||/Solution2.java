class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return ans;
        }
        int m1 = 0;
        int c1 = 0;
        int m2 = 0;
        int c2 = 0;
        for(int num: nums){
            if(m1 == num){
                c1 ++;
            }else if(m2 == num){
                c2 ++;
            }else if(c1 == 0){
                m1 = num;
                c1 = 1;
            }else if(c2 == 0){
                m2 = num;
                c2 = 1;
            }else{
                c1 --;
                c2 --;
            }
        }
        int cnt1 = 0;
        int cnt2 = 0;
        for(int num: nums){
            if(num == m1){
                cnt1++;
            }else if(num == m2){
                cnt2++;
            }
        }
        if(cnt1 > nums.length /3) ans.add(m1);
        if(cnt2 > nums.length /3) ans.add(m2);
        return ans;
    }
}