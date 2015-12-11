public class Solution {
    public String removeDuplicateLetters(String s) {
        if(s == null || s.length() < 1){
            return s;
        }
        
        HashMap<Character, Integer> pos = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++){
            pos.put(s.charAt(i), i);
        }
        int size = pos.size();
        int begin = 0;
        int end = findMinPos(pos);
        
        StringBuilder sb = new StringBuilder();
        while(sb.length() < size){
            char minChar = 'z' + 1;
            for(int i = begin; i <= end; i++){
                char c = s.charAt(i);
                if(c < minChar && pos.containsKey(c)){
                    minChar = c;
                    begin = i + 1;
                }
            }
            sb.append(minChar);
            pos.remove(minChar);
            if(minChar == s.charAt(end)){
                end = findMinPos(pos);
            }
        }
        
        return sb.toString();
    }
    
    private int findMinPos(HashMap<Character, Integer> pos){
        int ret = Integer.MAX_VALUE;
        for(int val : pos.values()){
            ret = Math.min(val, ret);
        }
        return ret;
    }
}