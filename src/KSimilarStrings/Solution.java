class Solution {
    public int kSimilarity(String A, String B) {
        if(A.equals(B)) return 0;
        HashSet<String> hs = new HashSet<>();
        hs.add(A);
        Queue<String> q = new LinkedList<>();
        q.add(A);
        int ret = 0;
        while(!q.isEmpty()){
            ret ++;
            int size = q.size();
            for(int k = 0; k < size; k++){
                String s = q.poll();
                int i = 0;
                while(s.charAt(i) == B.charAt(i)) i ++;
                for(int j = i + 1; j < B.length(); j++){
                    if(s.charAt(j) == B.charAt(j) || s.charAt(i) != B.charAt(j)) continue;
                    String tmp = swap(s, i, j);
                    if(tmp.equals(B)) return ret;
                    if(hs.add(tmp)) q.add(tmp);
                }
            }
        }

        return ret;
    }

    private String swap(String s, int i, int j){
        char[] charArray = s.toCharArray();
        char tmp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = tmp;
        return new String(charArray);
    }
}