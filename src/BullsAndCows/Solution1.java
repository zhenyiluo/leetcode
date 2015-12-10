public class Solution1 {
    public String getHint(String secret, String guess) {
        if(secret == null || guess == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int cntA = 0;
        int cntB = 0;
        int[] numA = new int[10];
        int[] numB = new int[10];
        int len = secret.length();
        for(int i = 0; i < len; i++){
            int indexA = secret.charAt(i) - '0';
            int indexB = guess.charAt(i) - '0';
            if(indexA == indexB){
                cntA ++;
            }else{
                numA[indexA] ++;
                numB[indexB] ++;
            }
        }
        
        for(int i = 0; i < 10; i++){
            cntB += Math.min(numA[i], numB[i]);
        }
        
        sb.append(cntA);
        sb.append("A");
        sb.append(cntB);
        sb.append("B");
        
        return sb.toString();
    }
}