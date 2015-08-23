public class Solution {
    public void reverseWords(char[] s) {
        if(s == null || s.length <= 1){
            return;
        }
        
        int n = s.length;
        reverseRange(s, 0, n-1);
        int prev = 0;
        int cur = 1;
        while(cur < n){
            while(cur < n && s[cur] != ' '){
                cur ++;
            }
            reverseRange(s, prev, cur -1);
            prev = cur + 1;
            cur = prev + 1;
        }
    }
    
    private void reverseRange(char[] s, int start, int end){
        while(start < end){
            swap(s, start, end);
            start ++; 
            end --;
        }
    }
    
    private void swap(char[] s, int i, int j){
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }
}