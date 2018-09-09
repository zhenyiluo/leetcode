import java.util.HashMap;

public class Solution {
    public static void main(String[] args){
        String s1 = "a";
        String s2 = "";
        String s3 = "a";
        System.out.println(new Solution().isInterleave(s1, s2, s3));
    }
    HashMap<String, Boolean> hm = new HashMap<String, Boolean>();
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1 == null || s2 == null || s3 == null){
            return false;
        }
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }
        HashMap<Character, Integer> chars = new HashMap<Character, Integer>();
        for(int i = 0; i < s1.length(); i++){
            char c = s1.charAt(i);
            if(chars.containsKey(c)){
                chars.put(c, chars.get(c) + 1);
            }else{
                chars.put(c, 1);
            }
        }

        for(int i = 0; i < s2.length(); i++){
            char c = s2.charAt(i);
            if(chars.containsKey(c)){
                chars.put(c, chars.get(c) + 1);
            }else{
                chars.put(c, 1);
            }
        }

        for(int i = 0; i < s3.length(); i++){
            char c = s3.charAt(i);
            if(chars.containsKey(c)){
                int val = chars.get(c);
                val --;
                if(val == 0){
                    chars.remove(c);
                }else{
                    chars.put(c, val);
                }
            }else{
                return false;
            }
        }

        if(chars.size() != 0){
            return false;
        }
        return dfs(s1, s2, s3);
    }

    private boolean dfs(String s1, String s2, String s3){
        if(s1.length() == 0 && s2.length() == 0 && s3.length() == 0){
            return true;
        }
        if(s2.compareTo(s1) < 0){
            String tmp = s1;
            s1 = s2;
            s2 = tmp;
        }
        String key = s1 + "#" + s2 + "#" + s3;
        if(!hm.containsKey(key)){
            if(s1.length() > 0 && s1.charAt(0) == s3.charAt(0)){
                if(dfs(s1.substring(1), s2, s3.substring(1))){
                    hm.put(key, true);
                    return true;
                }
            }

            if(s2.length() > 0 && s2.charAt(0) == s3.charAt(0)){
                if(dfs(s1, s2.substring(1), s3.substring(1))){
                    hm.put(key, true);
                    return true;
                }
            }

            hm.put(key, false);
        }
        return hm.get(key);
    }
}