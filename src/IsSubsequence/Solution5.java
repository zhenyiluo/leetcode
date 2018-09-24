class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s == null || t == null) return false;
        if(s.length() == 0) return true;
        if(t.length() == 0) return false;
        HashMap<Character, ArrayList<Integer>> hm = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            char c= t.charAt(i);
            if(!hm.containsKey(c)){
                hm.put(c, new ArrayList<>());
            }
            hm.get(c).add(i);
        }
        int prev = -1;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(!hm.containsKey(c)){
                return false;
            }
            ArrayList<Integer> list = hm.get(c);
            prev = binarySearch(prev, list);
            if(prev == -1) return false;
            prev ++;
        }
        return true;
    }

    private int binarySearch(int prev, ArrayList<Integer> list){
        int start = 0;
        int end = list.size();
        while(start < end){
            int mid = start + (end - start) / 2;
            if(list.get(mid) < prev){
                start = mid + 1;
            }else{
                end = mid;
            }
        }
        if(start == list.size()) return -1;
        return list.get(start);
    }
}