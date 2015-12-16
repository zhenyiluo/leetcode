public class Solution {
    public int maxProduct(String[] words) {
        int ret = 0;
        if(words == null || words.length < 2){
            return ret;
        }
        int len = words.length;
        for(int i = 0; i < len-1; i++){
            for(int j = i+1; j < len; j++){
                if(checkWords(words[i], words[j])){
                    ret = Math.max(ret, words[i].length() * words[j].length());
                }
            }
        }
        return ret;
    }
    
    private boolean checkWords(String word1, String word2){
        boolean[] marks = new boolean[26];
        for(int i = 0; i < word1.length(); i++){
            marks[word1.charAt(i) - 'a'] = true;
        }
        
        for(int i = 0; i < word2.length(); i++){
            if(marks[word2.charAt(i) - 'a']){
                return false;
            }
        }
        return true;
    }
}