class Solution {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if(words1 == null && words2 == null){
            return true;
        }
        if(words1.length == 0 && words2.length == 0){
            return true;
        }
        if(words1 == null || words1.length == 0 || words2 == null || words2.length == 0 || words1.length != words2.length){
            return false;
        }
        HashMap<String, Integer> wordToId = new HashMap<>();
        int cnt = 0;
        UF uf = new UF(2000);
        for(String[] pair : pairs){
            String s1 = pair[0];
            String s2 = pair[1];
            if(!wordToId.containsKey(s1)){
                wordToId.put(s1, cnt++);
            }
            if(!wordToId.containsKey(s2)){
                wordToId.put(s2, cnt++);
            }
            uf.union(wordToId.get(s1), wordToId.get(s2));
        }

        int n = words1.length;
        for(int i = 0; i < n; i++){
            if(words1[i].equals(words2[i])) continue;
            if(!wordToId.containsKey(words1[i]) || !wordToId.containsKey(words2[i])){
                return false;
            }
            if(uf.find(wordToId.get(words1[i])) != uf.find(wordToId.get(words2[i]))){
                return false;
            }
        }
        return true;
    }
}

class UF{
    int[] sz;
    int[] id;
    public UF(int n){
        sz = new int[n];
        id = new int[n];
        for(int i = 0; i < n; i++){
            sz[i] = 1;
            id[i] = i;
        }
    }

    public void union(int a, int b){
        int p = find(a);
        int q = find(b);
        if(p == q) return;
        if(sz[p] < sz[q]){
            sz[q] += sz[p];
            id[p] = q;
        }else{
            sz[p] += sz[q];
            id[q] = p;
        }
    }

    public int find(int i){
        while(i != id[i]){
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }
}