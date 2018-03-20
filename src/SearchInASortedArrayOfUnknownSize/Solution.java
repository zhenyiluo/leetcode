class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 20000;
        int ans = 0;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(reader.get(mid) == 2147483647){
                high = mid - 1;
            }else{
                low = mid + 1;
                ans = mid;
            }
        }
        low = 0;
        high = ans;
        while(low <= high){
            int mid = low + (high - low) /2;
            if(reader.get(mid) == target){
                return mid;
            }
            if(reader.get(mid) < target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return -1;
    }
}