class Solution {
    public int longestSubstring(String s, int k) {
        char[] arr = s.toCharArray();
        return helper(arr, 0, s.length(), k);
    }

    private int helper(char[] arr, int start, int end, int k){
        if(end - start < k) return 0;
        int[] cnt = new int[26];
        for(int i = start; i < end; i++){
            cnt[arr[i] - 'a'] ++;
        }
        for(int i = 0; i < 26; i++){
            if(cnt[i] >0 && cnt[i] < k){
                for(int j = start; j < end; j++){
                    if(arr[j] == i + 'a'){
                        int left = helper(arr, start, j, k);
                        int right = helper(arr, j + 1, end, k);
                        return Math.max(left, right);
                    }
                }
            }
        }
        return end - start;
    }
}