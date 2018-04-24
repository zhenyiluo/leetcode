class Solution2 {
    public String minWindow(String s, String t) {
        if(s == null || t == null || s.length() < t.length()) return "";
        int[] needToFind = new int[256];
        int[] hasFound = new int[256];
        for(int i = 0; i < t.length(); i++){
            needToFind[t.charAt(i)]++;
        }
        int start = 0;
        int end = 0;
        int minLen = Integer.MAX_VALUE;
        String ret = "";
        int count = 0;
        while(end < s.length()){
            char cur = s.charAt(end);
            if(needToFind[cur] == 0){
                end++;
                continue;
            }
            hasFound[cur]++ ;
            if(hasFound[cur] <= needToFind[cur]){
                count ++;
            }

            if(count == t.length()){
                while(needToFind[s.charAt(start)] == 0 || hasFound[s.charAt(start)] > needToFind[s.charAt(start)]){
                    if(needToFind[s.charAt(start)] > 0){
                        hasFound[s.charAt(start)] --;
                    }
                    start ++;
                }
                if(end - start + 1 < minLen){
                    minLen = end - start + 1;
                    ret = s.substring(start, end + 1);
                }
            }
            end++;
        }
        return ret;
    }
}