class Solution {
    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0) return 0;
        int[] longest = new int[s.length()];
        int ret = 0;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == ')'){
                int index = i - longest[i-1] - 1;
                if(index >= 0 && s.charAt(index) == '('){
                    longest[i] = longest[i-1] + 2;
                    if(index - 1 >= 0){
                        longest[i] += longest[index - 1];
                    }
                }
                ret = Math.max(ret, longest[i]);
            }
        }
        return ret;
    }
}