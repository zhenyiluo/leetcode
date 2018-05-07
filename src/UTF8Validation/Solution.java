class Solution {
    public boolean validUtf8(int[] data) {
        if(data == null || data.length == 0) return false;
        int len = data.length;
        int start = 0;
        while(start < len){
            int num = getFirstNumOfOnes(data[start]);
            if(num == 0){
                start ++;
            }else if(num == 1){
                return false;
            }else if(num == 2){
                if(start + 1 >= len || getFirstNumOfOnes(data[start+1]) != 1){
                    return false;
                }
                start += 2;
            }else if(num == 3){
                if(start + 2 >= len || getFirstNumOfOnes(data[start+1]) != 1 || getFirstNumOfOnes(data[start+2]) != 1){
                    return false;
                }
                start += 3;
            }else if(num == 4){
                if(start + 3 >= len || getFirstNumOfOnes(data[start+1]) != 1 || getFirstNumOfOnes(data[start+2]) != 1 || getFirstNumOfOnes(data[start+3]) != 1){
                    return false;
                }
                start += 4;
            }else{
                return false;
            }
        }
        return true;
    }
    private int getFirstNumOfOnes(int n){
        int num = 0;
        for(int i = 7; i >= 0; i --){
            if(((n >> i) & 1) == 1){
                num ++;
            }else{
                break;
            }
        }
        return num;
    }
}