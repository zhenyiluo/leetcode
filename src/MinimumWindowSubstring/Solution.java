class Solution {
    public String minWindow(String s, String t) {
        if(s == null || t == null || s.length() < t.length()) return "";
        int[] hasFound = new int[256];
        int[] needToFind = new int[256];

        String ret = "";
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < t.length(); i++){
            needToFind[t.charAt(i)] ++;
        }
        int count = 0;
        for(int begin = 0, end = 0; end < s.length(); end++){
            char c1 = s.charAt(end);
            if(needToFind[c1] == 0){
                continue;
            }

            hasFound[c1]++;

            if(hasFound[c1] <= needToFind[c1]){
                count ++;
            }

            if(count == t.length()){
                while(true){
                    char c2 = s.charAt(begin);
                    if(needToFind[c2] > 0 && needToFind[c2] >= hasFound[c2]){
                        break;
                    }
                    hasFound[c2]--;
                    begin ++;
                }
                if(end - begin + 1 < min){
                    min = end - begin + 1;
                    ret = s.substring(begin, end + 1);
                }
            }
        }
        return ret;
    }
}