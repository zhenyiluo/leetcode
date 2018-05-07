class Solution2 {
    public int maxProduct(String[] words) {
        if(words == null || words.length == 0) return 0;
        int len = words.length;
        BitSet[] bitSets = new BitSet[len];
        for(int i = 0; i < len; i++){
            bitSets[i] = new BitSet();
            for(int j = 0; j < words[i].length(); j++){
                bitSets[i].set(words[i].charAt(j) - 'a');
            }
        }
        int ret = 0;
        for(int i = 0; i < len; i++){
            for(int j = i + 1; j < len; j++){
                BitSet tmp = (BitSet) bitSets[i].clone();
                tmp.and(bitSets[j]);
                if(tmp.isEmpty()){
                    ret = Math.max(ret, words[i].length() * words[j].length());
                }
            }
        }
        return ret;
    }
}