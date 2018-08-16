class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> ans = new ArrayList<>();
        if(words == null || words.length == 0) return ans;
        HashMap<String, Integer> wordCount = new HashMap<>();
        for(String word: words){
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a, b) -> (a.getValue() == b.getValue() ?
                b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue()));
        for(Map.Entry<String, Integer> entry: wordCount.entrySet()){
            pq.add(entry);
            if(pq.size() > k){
                pq.poll();
            }
        }
        while(!pq.isEmpty()){
            ans.add(0, pq.poll().getKey());
        }
        return ans;
    }
}
