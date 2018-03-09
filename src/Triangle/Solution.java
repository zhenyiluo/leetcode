class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int sz = triangle.size();
        int[] result = new int[sz+1];
        for(int i = sz -1; i >=0; i--){
            List<Integer> tmp = triangle.get(i);
            for(int j = 0; j < tmp.size(); j++){
                result[j] = Math.min(result[j], result[j+1]) + tmp.get(j);
            }
        }
        return result[0];
    }
}