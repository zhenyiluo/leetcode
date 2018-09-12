class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> ans = new ArrayList<>();
        Arrays.sort(words, (a, b) -> (a.length() - b.length()));
        HashSet<String> dict = new HashSet<>();
        for(String word: words){
            if(canForm(word, dict)){
                ans.add(word);
            }
            dict.add(word);
        }
        return ans;
    }

    private boolean canForm(String word, HashSet<String> dict){
        if(dict.isEmpty()) return false;
        int len = word.length();
        boolean[] dp = new boolean[len+1];
        dp[0] = true;
        for(int i = 1; i <= len; i++){
            for(int j = 0; j < i; j++){
                if(!dp[j]) continue;
                if(dict.contains(word.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
}