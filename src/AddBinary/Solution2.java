class Solution2 {
    public String addBinary(String a, String b) {
        if(a == null && b == null) return "";
        if(a == null) return b;
        if(b == null) return a;
        StringBuilder sb = new StringBuilder();
        int i = a.length() -1;
        int j = b.length() -1;
        int carryOver = 0;
        while(i >= 0 || j >= 0){
            int sum = carryOver;
            if(i >= 0)  sum += a.charAt(i--) - '0';
            if(j >= 0)  sum += b.charAt(j--) - '0';
            carryOver = sum / 2;
            sb.append(sum % 2);
        }
        if(carryOver != 0){
            sb.append(carryOver);
        }
        return sb.reverse().toString();
    }
}