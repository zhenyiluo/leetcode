class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0) return "0";
        boolean negative = (numerator < 0) ^ (denominator < 0);
        long a = Math.abs((long) numerator);
        long b = Math.abs((long) denominator);
        StringBuilder sb = new StringBuilder();
        sb.append(a/b);
        String ret = "";
        if(negative) {
            ret = "-";
        }
        if(a % b == 0){
            ret = ret + sb.toString();
            return ret;
        }
        HashMap<Long, Integer> hm = new HashMap<>();
        sb.append(".");
        long remain = a % b;
        while(remain != 0){
            if(hm.containsKey(remain)){
                int index = hm.get(remain);
                sb.insert(index, "(");
                sb.append(")");
                break;
            }
            hm.put(remain, sb.length());
            remain *= 10;
            sb.append(remain / b);
            remain %= b;
        }
        ret = ret + sb.toString();
        return ret;
    }
}