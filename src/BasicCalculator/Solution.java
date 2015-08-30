import java.util.Stack;

public class Solution {
    public static void main(String[] args){
        System.out.println(new Solution().calculate("1 - (5)"));
    }
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0;
        int sign = 1;
        int num = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c >= '0' && c <= '9'){
                num = num * 10 + c- '0';
            }else if(c == '+'){
                result += sign * num;
                sign = 1;
                num = 0;
            }else if(c == '-'){
                result += sign * num;
                sign = -1;
                num = 0;
            }else if(c == '('){
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            }else if(c == ')'){
                result += sign * num;
                num = 0;
                result *= stack.pop();
                result += stack.pop();
            }
        }
        if(num != 0){
            result += sign * num;
        }
        return result;
    }
}