public class Solution {
    public String reverseWords(String s) {
        if(s == null) return null;
        String[] ss = s.trim().split("\\s+");
        if(ss.length == 0) return "";
        int left = 0;
        int right = ss.length -1;
        while(left < right){
            String tmp = ss[left];
            ss[left] = ss[right];
            ss[right] = tmp;
            left ++;
            right --;
        }
        StringBuilder ret = new StringBuilder(ss[0]);
        for(int i = 1; i < ss.length; i++){
            ret.append(' ');
            ret.append(ss[i]);
        }
        return ret.toString();
    }
}