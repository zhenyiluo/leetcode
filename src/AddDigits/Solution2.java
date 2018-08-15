class Solution {
    public int addDigits(int num) {
        if(num < 10) return num;
        int ret = 0;
        while(num != 0){
            ret += num % 10;
            num /= 10;
        }
        return addDigits(ret);
    }
}