class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) return null;
        HashMap<String, List<String>> hm = new HashMap<>();
        for(String s: strs){
            char[] charArr = s.toCharArray();
            Arrays.sort(charArr);
            String newS = String.valueOf(charArr);
            if(!hm.containsKey(newS)){
                hm.put(newS, new LinkedList<>());
            }
            hm.get(newS).add(s);
        }

        return new LinkedList<>(hm.values());
    }
}