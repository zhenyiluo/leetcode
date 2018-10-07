class Solution {
    public String minWindow(String s, String t) {
        if(s == null || t == null || s.length() == 0 || t.length() == 0) return "";
        int[] hasFound = new int[256];
        int[] needToFind = new int[256];
        for(int i = 0; i < t.length(); i++){
            needToFind[t.charAt(i)] ++;
        }
        int i = 0;
        int cnt = 0;
        String ans = "";
        int min = Integer.MAX_VALUE;
        for(int j = 0; j < s.length(); j++){
            char c = s.charAt(j);
            if(needToFind[c] == 0) continue;
            if(hasFound[c] < needToFind[c]){
                cnt ++;
            }
            hasFound[c] ++;
            if(cnt == t.length()){
                while(needToFind[s.charAt(i)] == 0 || hasFound[s.charAt(i)] > needToFind[s.charAt(i)]){
                    if(needToFind[s.charAt(i)] != 0){
                        hasFound[s.charAt(i)]--;
                    }
                    i++;
                }
                int tmp = j - i + 1;
                if(tmp < min){
                    min = tmp;
                    ans = s.substring(i, j + 1);
                }
            }
        }
        return ans;
    }
}