class Solution {
    static int[] M = new int[]{100, 1000, 1000000, 1000000000};
    static String[] digit = new String[]{"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    static String[] tens = new String[]{"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    static String[] others = new String[]{"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    public String numberToWords(int num) {
        if(num == 0) return digit[0];
        StringBuilder sb = new StringBuilder();
        if(num / M[3] != 0){
            helper(sb, num / M[3]);
            sb.append(" Billion");
        }
        num -= num / M[3] * M[3];
        if(num / M[2] != 0){
            helper(sb, num / M[2]);
            sb.append(" Million");
        }
        num -= num/M[2] * M[2];
        if(num / M[1] != 0){
            helper(sb, num / M[1]);
            sb.append(" Thousand");
        }
        num -= num / M[1] * M[1];
        helper(sb, num);
        return sb.toString().trim();
    }

    private void helper(StringBuilder sb, int n){
        if(n / M[0] != 0){
            helperWH(sb, n / M[0]);
            sb.append(" Hundred");
        }
        n -= n / M[0] * M[0];
        helperWH(sb, n);
    }

    private void helperWH(StringBuilder sb, int n){
        if(n >= 20){
            sb.append(" ");
            sb.append(others[n/10 - 2]);
            n -= n/10 * 10;
            if(n != 0){
                sb.append(" ");
                sb.append(digit[n]);
            }
        }else if (n >= 10){
            sb.append(" ");
            sb.append(tens[n - 10]);
        }else if (n > 0){
            sb.append(" ");
            sb.append(digit[n]);
        }
    }
}