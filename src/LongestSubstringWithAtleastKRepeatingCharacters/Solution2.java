class Solution {
    public int longestSubstring(String s, int k) {
        int max = 0;
        for(int h = 1; h <= 26; h++){
            int i = 0;
            int j = 0;
            int unique = 0;
            int notLessThanK = 0;
            int[] counts = new int[26];
            while(j < s.length()){
                if(unique <= h){
                    int idx = s.charAt(j) - 'a';
                    if(counts[idx] == 0){
                        unique ++;
                    }
                    counts[idx] ++;
                    if(counts[idx] == k){
                        notLessThanK ++;
                    }
                    j++;
                }else{
                    int idx = s.charAt(i) - 'a';
                    if(counts[idx] == k){
                        notLessThanK --;
                    }
                    counts[idx] --;
                    if(counts[idx] == 0){
                        unique --;
                    }
                    i++;
                }
                if(unique == h && notLessThanK == h){
                    max = Math.max(max, j - i);
                }
            }
        }
        return max;
    }
}