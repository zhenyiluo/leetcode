import java.util.*;
public class Solution1 {
    public int calculate(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        s = s.trim();
        int len = s.length();
        if(len == 0){
            return 0;
        }
        Stack<Integer> stNum = new Stack<>();
        Stack<Character> stOp = new Stack<>();
        int start = 0;
        while(start < len){
            char c = s.charAt(start);
            if(isDigit(c)){
                int j = start;
                while(j < len && isDigit(s.charAt(j))){
                    j++;
                }
                int num = Integer.valueOf(s.substring(start, j));
                stNum.push(num);
                start = j;
            }else if("+-*/".indexOf(c) != -1){
                while(!stOp.isEmpty() && getOrder(stOp.peek()) >= getOrder(c)){
                    int op2 = stNum.pop();
                    int op1 = stNum.pop();
                    stNum.push(evaluate(stOp.pop(), op1, op2));

                }
                stOp.push(c);
                start ++;
            }else{
                start ++;
            }
        }

        while(!stOp.isEmpty()){
            int op2 = stNum.pop();
            int op1 = stNum.pop();
            stNum.push(evaluate(stOp.pop(), op1, op2));
        }

        return stNum.pop();
    }

    private int evaluate(char c, int op1, int op2){
        if(c == '+'){
            return op1 + op2;
        }else if (c == '-'){
            return op1 - op2;
        }else if(c == '*'){
            return op1 * op2;
        }else{
            return op1 / op2;
        }
    }
    private boolean isDigit(char c){
        return c >= '0' && c <= '9';
    }

    private int getOrder(char c){
        if(c == '+' || c == '-'){
            return 1;
        }
        return 2;
    }
}