class Solution {
    public String complexNumberMultiply(String a, String b) {
        String[] str1Arr = a.split("\\+");
        String[] str2Arr = b.split("\\+");
        int a1 = Integer.valueOf(str1Arr[0]);
        int b1 = Integer.valueOf(str1Arr[1].substring(0, str1Arr[1].length() -1));
        int a2= Integer.valueOf(str2Arr[0]);
        int b2 = Integer.valueOf(str2Arr[1].substring(0, str2Arr[1].length() -1));
        StringBuilder ret = new StringBuilder();
        int a3 = a1 * a2 - b1 * b2;
        int b3 = a1 * b2 + a2 * b1;
        ret.append(a3);
        ret.append('+');
        ret.append(b3);
        ret.append('i');
        return ret.toString();
    }
}