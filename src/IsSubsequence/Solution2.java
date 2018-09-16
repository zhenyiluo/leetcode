class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s == null || t == null) return false;
        HashMap<Character, ArrayList<Integer>> hm = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            if(!hm.containsKey(c)){
                hm.put(c, new ArrayList<>());
            }
            hm.get(c).add(i);
        }

        int prev = -1;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            ArrayList<Integer> list = hm.get(c);
            if(list == null) return false;
            prev = helper(prev, list);
            if(prev == -1) return false;
            prev ++;
        }
        return true;
    }

    private int helper(int idx, ArrayList<Integer> list){
        int start = 0;
        int end = list.size() -1 ;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(list.get(mid) < idx){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return start == list.size() ? -1 : list.get(start);
    }
}