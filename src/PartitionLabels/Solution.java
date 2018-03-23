class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> ret = new ArrayList<>();
        if(S == null || S.length() == 0){
            return ret;
        }
        int[] map = new int[26];
        for(int i = 0; i < S.length(); i++){
            map[S.charAt(i) - 'a'] = i;
        }

        int start = 0;
        int last = 0;
        for(int i = 0; i < S.length(); i++){
            last = Math.max(last, map[S.charAt(i) - 'a']);
            if(last == i){
                ret.add(last - start + 1);
                start = last + 1;
            }
        }
        return ret;
    }
}