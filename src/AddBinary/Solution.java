class Solution {
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
            if(i >= 0){
                sum += a.charAt(i) - '0';
            }

            if(j >= 0){
                sum += b.charAt(j) - '0';
            }
            int remain = sum % 2;
            carryOver = sum / 2;
            sb.insert(0, String.valueOf(remain));
            i--;
            j--;
        }

        if(carryOver != 0){
            sb.insert(0, String.valueOf(carryOver));
        }
        return sb.toString();
    }
}