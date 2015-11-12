public class WordDistance {
    String[] words;
    HashMap<String, Integer> cache = new HashMap<String, Integer>();
    HashMap<String, ArrayList<Integer>> hm = new HashMap<String, ArrayList<Integer>>();
    public WordDistance(String[] words) {
        this.words = words;
        for(int i = 0; i < words.length; i++){
            if(hm.containsKey(words[i])){
                ArrayList<Integer> list = hm.get(words[i]);
                list.add(i);
            }else{
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(i);
                hm.put(words[i], list);
            }
        }
    }

    public int shortest(String word1, String word2) {
        if(word1.compareTo(word2) > 0){
            String tmp = word1;
            word1 = word2;
            word2 = tmp;
        }
        String key = word1 + "#" + word2;
        if(!cache.containsKey(key)){
            ArrayList<Integer> list1 = hm.get(word1);
            ArrayList<Integer> list2 = hm.get(word2);
            int ret = Integer.MAX_VALUE;
            int i = 0; 
            int j = 0;
            while(i < list1.size() && j < list2.size()){
                ret = Math.min(ret, Math.abs(list1.get(i) - list2.get(j)));
                if(list1.get(i) < list2.get(j)){
                    i++;
                }else{
                    j++;
                }
            }
            cache.put(key, ret);
        }
        
        return cache.get(key);
    }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");