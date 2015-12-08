public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] sep = str.split(" ");
        String[] mapping = new String[26];
        int len1 = pattern.length();
        int len2 = sep.length;
        if(len1 != len2){
            return false;
        }
        
        for(int i = 0; i < len1; i++){
            char c = pattern.charAt(i);
            int index = c - 'a';
            if(mapping[index] == null){
                for(int j = 0; j < 26; j++){
                    if(mapping[j] != null){
                        if(mapping[j].equals(sep[i])){
                            return false;
                        }
                    }
                }
                mapping[index] = sep[i];
            }else{
                if(!mapping[index].equals(sep[i])){
                    return false;
                } 
            }
        }
        return true;
    }
}