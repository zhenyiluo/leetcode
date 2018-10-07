class Solution {
    public String frequencySort(String s) {
        if(s == null || s.length() <= 1) return s;
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i = 0 ;i < s.length(); i++){
            char c = s.charAt(i);
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }
        ArrayList<Character>[] buckets = new ArrayList[s.length() + 1];
        for(char c: hm.keySet()){
            int cnt = hm.get(c);
            if(buckets[cnt] == null){
                buckets[cnt] = new ArrayList<>();
            }
            buckets[cnt].add(c);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = s.length(); i>= 0; i --){
            if(buckets[i] != null){
                ArrayList<Character> list = buckets[i];
                for(char c : list){
                    for(int j = 0; j < i; j++){
                        sb.append(c);
                    }
                }
            }
        }
        return sb.toString();
    }
}