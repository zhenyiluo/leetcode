public class Solution {
    public boolean isPowerOfThree(int n) {
        return Double.compare((Math.log10(n) / Math.log10(3)) % 1, 0) == 0;
    }
}