class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int start = 0;
        int end = arr.length -1;
        int startPos = -1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(mid + k - 1 >= arr.length){
                end = mid -1;
            }else if(mid -1 >= 0 && x - arr[mid-1] <= arr[mid + k -1] - x){
                end = mid -1;
            }else if(mid + k < arr.length && x - arr[mid] > arr[mid+k] -x){
                start = mid + 1;
            }else{
                startPos = mid;
                break;
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < k; i++){
            list.add(arr[startPos++]);
        }
        return list;
    }
}