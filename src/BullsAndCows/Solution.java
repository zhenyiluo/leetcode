public class Solution {
    public String getHint(String secret, String guess) {
        if(secret == null || guess == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int cntA = 0;
        int cntB = 0;
        int[] num = new int[10];
        int len1 = secret.length();
        int len2 = guess.length();
        for(int i = 0; i < len1; i++){
            int index = secret.charAt(i) - '0';
            num[index] ++;
        }
        int minLen = Math.min(len1, len2);
        for(int i = 0; i < minLen; i++){
            int index = guess.charAt(i) - '0';
            if(i < len1 && guess.charAt(i) == secret.charAt(i)){
                cntA++;
                if(num[index] > 0){
                    num[index] --;
                }
            }
        }
        
        for(int i = 0; i < len2; i++){
            int index = guess.charAt(i) - '0';
            if(i >= len1 || guess.charAt(i) != secret.charAt(i)){
                if(num[index] > 0){
                    num[index] --;
                    cntB++;
                }
            }
        }
        
        sb.append(cntA);
        sb.append("A");
        sb.append(cntB);
        sb.append("B");
        
        return sb.toString();
    }
}