class Solution {
    public String rearrangeString(String s, int k) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> (b.getValue() != a.getValue()
                ? b.getValue() - a.getValue() : a.getKey() - b.getKey()));
        for(Map.Entry<Character, Integer> entry : hm.entrySet()){
            pq.add(entry);
        }
        StringBuilder sb = new StringBuilder();
        Queue<Map.Entry<Character, Integer>> waitQueue = new LinkedList<>();
        while(!pq.isEmpty()){
            Map.Entry<Character, Integer> entry = pq.poll();
            sb.append(entry.getKey());
            waitQueue.offer(entry);

            if(waitQueue.size() < k){
                continue;
            }

            Map.Entry<Character, Integer> front = waitQueue.poll();
            if(front.getValue() > 1){
                front.setValue(front.getValue() -1);
                pq.add(front);
            }
        }

        return sb.length() == s.length() ? sb.toString() : "";
    }
}