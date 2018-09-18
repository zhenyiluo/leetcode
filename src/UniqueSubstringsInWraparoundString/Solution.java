class Solution {
    public int findSubstringInWraproundString(String p) {
        int[] cnt = new int[26];
        int count = 0;
        for(int i = 0; i < p.length(); i++){
            if(i > 0 && (p.charAt(i) - p.charAt(i-1) == 1 || p.charAt(i) - p.charAt(i-1) == -25)){
                count ++;
            }else{
                count = 1;
            }
            cnt[p.charAt(i) - 'a'] = Math.max(cnt[p.charAt(i) - 'a'], count);
        }
        int ans = 0;
        for(int i = 0; i < 26; i++){
            ans += cnt[i];
        }
        return ans;
    }
}