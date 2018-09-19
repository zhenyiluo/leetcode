class Solution {
    public String pushDominoes(String dominoes) {
        if(dominoes == null || dominoes.length() == 0) return "";
        int n = dominoes.length();
        int[] left = new int[n];
        int[] right = new int[n];
        for(int i = 0; i < n; i++){
            left[i] = -1;
            right[i] = -1;
        }
        for(int i = 0; i < n; i++){
            if(dominoes.charAt(i) == 'R'){
                right[i] = 0;
            }else if(dominoes.charAt(i) == '.' && i > 0 && right[i-1] != -1){
                right[i] = right[i-1] + 1;
            }
        }
        for(int i = n-1; i >= 0; i--){
            if(dominoes.charAt(i) == 'L'){
                left[i] = 0;
            }else if(dominoes.charAt(i) == '.' && i < n-1 && left[i+1] != -1){
                left[i] = left[i+1] + 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            if(left[i] == right[i]){
                sb.append('.');
            }else if(left[i] == -1){
                sb.append('R');
            }else if(right[i] == -1){
                sb.append('L');
            }else if(left[i] < right[i]){
                sb.append('L');
            }else{
                sb.append('R');
            }
        }
        return sb.toString();
    }
}