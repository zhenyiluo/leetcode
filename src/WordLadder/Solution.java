class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList == null) {
            return 0;
        }
        HashSet<String> hs = new HashSet<>();
        for(String str: wordList) {
            hs.add(str);
        }
        if(!hs.contains(endWord)){
            return 0;
        }

        int len = beginWord.length();
        Queue<String> q = new LinkedList<>();
        Queue<Integer> level = new LinkedList<>();
        q.add(beginWord);
        level.add(1);
        while(!q.isEmpty()){
            String tmp = q.poll();
            int tmpL = level.poll();
            if(tmp.equals(endWord)){
                return tmpL;
            }else{
                for(int i = 0; i < len; i++){
                    for(char c = 'a'; c <='z'; c++){
                        if(c != tmp.charAt(i)){
                            StringBuilder sb = new StringBuilder(tmp);
                            sb.setCharAt(i, c);
                            if(hs.contains(sb.toString())){
                                hs.remove(sb.toString());
                                q.add(sb.toString());
                                level.add(tmpL+1);
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }
}