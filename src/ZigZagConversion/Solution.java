class Solution {
    public String convert(String s, int numRows) {
        StringBuilder[] sbs = new StringBuilder[numRows];
        int len = s.length();

        for(int j = 0; j < numRows; j++) sbs[j] = new StringBuilder();
        int i = 0;
        while(i < len){
            for(int index = 0; index < numRows && i < len; index++){
                sbs[index].append(s.charAt(i++));
            }

            for(int index = numRows -2; index >= 1 && i < len; index--){
                sbs[index].append(s.charAt(i++));
            }
        }

        for(int k = 1; k < numRows; k++){
            sbs[0].append(sbs[k]);
        }
        return sbs[0].toString();
    }
}