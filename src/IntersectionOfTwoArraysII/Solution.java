class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hm1 = new HashMap<>();
        HashMap<Integer, Integer> hm2 = new HashMap<>();
        for(int num1: nums1){
            hm1.put(num1, hm1.getOrDefault(num1, 0) + 1);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int num2: nums2){
            if(hm1.containsKey(num2) && hm1.get(num2) > 0){
                hm1.put(num2, hm1.get(num2) - 1);
                list.add(num2);
            }
        }
        int[] ret = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            ret[i] = list.get(i);
        }
        return ret;
    }
}