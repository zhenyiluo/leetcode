class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0) return 0;
        int n = envelopes.length;
        Arrays.sort(envelopes, (a, b) -> (a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]));
        int[] arr = new int[n];
        int i = 0;
        for(int[] envelope: envelopes){
            arr[i++] = envelope[1];
        }
        return findLongestLength(arr);
    }

    private int findLongestLength(int[] arr){
        int n = arr.length;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(list.isEmpty()){
                list.add(arr[i]);
            }else{
                int start = 0;
                int end = list.size();
                while(start < end){
                    int mid = start + (end - start) / 2;
                    if(list.get(mid) < arr[i]){
                        start = mid + 1;
                    }else{
                        end = mid;
                    }
                }
                if(start < list.size()){
                    list.set(start, arr[i]);
                }else{
                    list.add(arr[i]);
                }
            }
        }
        return list.size();
    }
}