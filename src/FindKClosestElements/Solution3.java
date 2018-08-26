class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int start = 0;
        int end = arr.length - k;
        while(start < end){
            int mid = start + (end - start) / 2;
            if(x - arr[mid] > arr[mid + k] -x){
                start = mid + 1;
            }else{
                end = mid;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < k; i++){
            ans.add(arr[start++]);
        }
        return ans;
    }
}