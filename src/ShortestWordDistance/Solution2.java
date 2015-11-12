public class Solution2 {
    public int shortestDistance(String[] words, String word1, String word2) {
        int index = -1;
        int ret = Integer.MAX_VALUE;
        for(int i = 0; i < words.length; i++){
            if(words[i].equals(word1) || words[i].equals(word2)){
                if(index != -1 && !words[index].equals(words[i])){
                    ret = Math.min(ret, i - index);
                }
                index = i;
            }
        }
        return ret;
    }
}