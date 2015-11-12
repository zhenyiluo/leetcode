public class Solution1 {
    public boolean isStrobogrammatic(String num) {
        for(int i = 0, j = num.length() -1; i <= j; i++, j--)
            if(!"008811969".contains(num.charAt(i) + "" + num.charAt(j)))
                return false;
        return true;
    }
}