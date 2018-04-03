class Solution {
    public String licenseKeyFormatting(String S, int K) {
        S = S.replace("-", "").toUpperCase();
        StringBuilder sb = new StringBuilder(S);
        int n = sb.length();
        for(int i = K ; i < n; i += K){
            sb.insert(n - i, "-");
        }
        return sb.toString();
    }
}