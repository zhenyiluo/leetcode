class Solution {
    public int repeatedStringMatch(String A, String B) {
        if(A == null || B == null || A.length() == 0 || B.length() == 0) return -1;
        StringBuilder sb = new StringBuilder(A);
        int count = 1;
        while(sb.length() < B.length()){
            sb.append(A);
            count ++;
        }

        if(sb.toString().contains(B)) return count;
        if(sb.append(A).toString().contains(B)) return ++count;
        return -1;
    }
}