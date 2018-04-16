class Solution {
    public String solveEquation(String equation) {
        String[] strArr = equation.split("=");
        Result left = extract(strArr[0]);
        Result right = extract(strArr[1]);
        int xfactor = left.x - right.x;
        int num = right.val - left.val;
        String result = "";
        if(xfactor == 0 && num == 0){
            result = "Infinite solutions";
        }else if(xfactor == 0 && num != 0){
            result = "No solution";
        }else{
            result = "x=" + String.valueOf(num/xfactor);
        }
        return result;
    }

    private Result extract(String s){
        Result result = new Result();
        int x = 0;
        int val = 0;
        int positive = 1;
        int sum = 0;
        for(int i = 0; i <= s.length(); i++){
            if(i == s.length() || s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == 'x'){
                if(i == s.length()){
                    val += sum * positive;
                }else if(s.charAt(i) == 'x'){
                    if(sum == 0){
                        if(i-1 >= 0 && s.charAt(i-1) == '0'){
                            sum = 0;
                        }else{
                            sum = 1;
                        }
                    }
                    x += sum * positive;
                    sum = 0;
                }else if(s.charAt(i) == '-'){
                    if(i-1 >= 0 && s.charAt(i-1) != 'x'){
                        val += sum * positive;
                    }
                    sum = 0;
                    positive = -1;
                }else{
                    if(i-1 >= 0 && s.charAt(i-1) != 'x'){
                        val += sum * positive;
                    }
                    sum = 0;
                    positive = 1;
                }
            }else{
                sum = sum * 10 + (s.charAt(i) - '0');
            }
        }
        result.val = val;
        result.x = x;
        return result;
    }

}

class Result{
    int x;
    int val;
}