class Solution {
    public String countAndSay(int n) {
        if(n < 1) return "";
        if(n == 1) return "1";
        String ret = "1";
        for(int i = 1; i < n; i++){
            ret = transform(ret);
        }
        return ret;
    }

    private String transform(String str){
        StringBuilder sb = new StringBuilder();
        int count = 0;
        char prev = 'x';
        char cur = 'x';
        for(int i = 0; i < str.length(); i++){
            cur = str.charAt(i);
            if(cur != prev){
                if(i != 0){
                    sb.append(count);
                    sb.append(prev);
                }
                prev = cur;
                count = 1;
            }else{
                count ++;
            }
        }
        sb.append(count);
        sb.append(cur);
        return sb.toString();
    }
}