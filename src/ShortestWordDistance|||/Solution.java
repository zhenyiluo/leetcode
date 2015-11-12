public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int index = -1;
        int ret = Integer.MAX_VALUE;
        if(!word1.equals(word2)){
            for(int i = 0; i < words.length; i++){
                if(words[i].equals(word1) || words[i].equals(word2)){
                    if(index != -1 && !words[index].equals(words[i])){
                        ret = Math.min(ret, i - index);
                    }
                    index = i;
                }
            }
        }else{
            for(int i = 0; i < words.length; i++){
                if(words[i].equals(word1)){
                    if(index != -1){
                        ret = Math.min(ret, i - index);
                    }
                    index = i;
                }
            }
        }
        return ret;
    }
}

