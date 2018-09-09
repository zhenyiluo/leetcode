class Solution {
    public int numDistinct(String s, String t) {
        if(s == null || t == null || s.length() == 0 || t.length() == 0) return 0;
        HashMap<Character, List<Integer>> mapping = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            if(!mapping.containsKey(s.charAt(i))){
                mapping.put(s.charAt(i), new LinkedList<>());
            }
            mapping.get(s.charAt(i)).add(i);
        }
        TreeMap<Integer, Integer> prev = null;
        TreeMap<Integer, Integer> cur = null;
        for(int i = 0; i < t.length(); i++){
            cur = new TreeMap<>();
            char c = t.charAt(i);
            List<Integer> indexes = mapping.get(c);
            int sum = 0;
            if(indexes != null){
                for(int idx: indexes){
                    if(prev == null){
                        sum += 1;
                    }else{
                        if(prev.floorKey(idx-1) != null){
                            sum += prev.get(prev.floorKey(idx-1));
                        }
                    }
                    cur.put(idx, sum);
                }
            }
            prev = cur;
        }
        return cur.isEmpty() ? 0 : cur.get(cur.lastKey());
    }
}