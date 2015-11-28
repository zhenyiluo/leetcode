import java.util.*;
public class Solution1 {
    public int calculate(String s) {
        if(s == null){
            return 0;
        }

        s = s.trim();
        int len = s.length();
        if(len == 0){
            return 0;
        }

        int start = 0;
        Stack<Integer> stOp = new Stack<>();
        Stack<Character> stChar = new Stack<>();
        while(start < len){
            char c = s.charAt(start);
            if(("(+-) ".indexOf(c) != -1)){
                if("(+-".indexOf(c) != -1){
                    if(c == '('){
                       stChar.push(c); 
                    }else{
                       while(!stChar.isEmpty() && getOrder(stChar.peek()) >= getOrder(c)){
                           char tmp = stChar.pop();
                           int op2 = stOp.pop();
                           int op1 = stOp.pop();
                           if(tmp == '+'){
                               stOp.push(op1 + op2);
                           }else{
                               stOp.push(op1 - op2);
                           }
                       }
                       stChar.push(c);
                    }
                }else if(c == ')'){
                    char tmp;
                    while((tmp = stChar.pop()) != '('){
                        int op2 = stOp.pop();
                        int op1 = stOp.pop();
                        if(tmp == '+'){
                            stOp.push(op1 + op2);
                        }else{
                            stOp.push(op1 - op2);
                        }
                    }
                }
                start++;
            }else{
                int j = start;
                while(j < len && isDigit(s.charAt(j))){
                    j ++;
                }
                int num = Integer.valueOf(s.substring(start, j));
                stOp.push(num);
                start = j;
            }
        }

        while(!stChar.isEmpty()){
            char c = stChar.pop();
            int op2 = stOp.pop();
            int op1 = stOp.pop();
            if(c == '+'){
                stOp.push(op1 + op2);
            }else{
                stOp.push(op1 - op2);
            }
        }

        return stOp.pop();
    }
    
    private int getOrder(char c){
        if(c == '+' || c == '-'){
            return 1;
        }
        return 0;
    }
    
    private boolean isDigit(char c){
        return c >= '0' && c <= '9';
    }
}