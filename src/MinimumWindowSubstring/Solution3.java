class Solution {
    public String minWindow(String s, String t) {
        if(s == null || t == null || s.length() == 0 || t.length() == 0) return "";
        int minSize = Integer.MAX_VALUE;
        String res = "";
        int[] needToFind = new int[256];
        int[] hasFound = new int[256];
        for(int i = 0; i < t.length(); i++){
            needToFind[t.charAt(i)] ++;
        }
        int start = 0;
        int end = 0;
        int count = 0;
        while(end < s.length()){
            char c = s.charAt(end);
            if(needToFind[c] == 0){
                end++;
                continue;
            }
            hasFound[c] ++;
            if(hasFound[c] <= needToFind[c]){
                count ++;
            }
            if(count == t.length()){
                while(needToFind[s.charAt(start)] == 0 || hasFound[s.charAt(start)] > needToFind[s.charAt(start)]){
                    if(needToFind[s.charAt(start)] > 0){
                        hasFound[s.charAt(start)]--;
                    }
                    start ++;
                }
                if(end - start + 1 < minSize){
                    minSize = end - start + 1;
                    res = s.substring(start, end + 1);
                }
            }
            end++;
        }
        return res;
    }
}