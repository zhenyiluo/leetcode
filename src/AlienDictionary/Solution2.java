class Solution {
    public String alienOrder(String[] words) {
        if(words == null || words.length == 0) return "";
        HashSet<Character> hs = new HashSet<>();
        ArrayList<char[]> pairs = new ArrayList<>();
        for(int i = 0; i < words.length; i++){
            String cur = words[i];
            for(int j= 0; j < cur.length(); j++){
                hs.add(cur.charAt(j));
            }
            if(i != 0){
                String prev = words[i-1];
                int lenPrev = prev.length();
                int lenCur = cur.length();
                int minLen = Math.min(lenPrev, lenCur);
                for(int j = 0; j < minLen; j++){
                    if(prev.charAt(j) == cur.charAt(j)) continue;
                    pairs.add(new char[]{prev.charAt(j), cur.charAt(j)});
                    break;
                }
            }
        }
        return getOrder(hs, pairs);
    }

    private String getOrder(HashSet<Character> hs, ArrayList<char[]> pairs){
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> degree = new HashMap<>();
        for(char c : hs){
            degree.put(c, 0);
        }
        for(char[] pair : pairs){
            degree.put(pair[1], degree.get(pair[1]) + 1);
        }
        Queue<Character> q = new LinkedList<>();
        for(char key: degree.keySet()){
            if(degree.get(key) == 0){
                q.add(key);
            }
        }

        while(!q.isEmpty()){
            char target = q.poll();
            sb.append(target);
            for(char[] pair: pairs){
                if(pair[0] == target){
                    degree.put(pair[1], degree.get(pair[1]) -1);
                    if(degree.get(pair[1]) == 0){
                        q.add(pair[1]);
                    }
                }
            }
        }

        for(char key: degree.keySet()){
            if(degree.get(key) != 0) return "";
        }

        return sb.toString();
    }
}