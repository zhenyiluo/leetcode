import java.util.Stack;

public class Solution {
    public static void main(String[] args){
        System.out.println(new Solution().calculate(" 2-1 + 2 "));
    }
    public int calculate(String s) {
        Stack<Integer> st1 = new Stack<Integer>();
        Stack<Character> st2 = new Stack<Character>();
        for(int i = 0; i < s.length(); ){
            char c = s.charAt(i);
            switch(c){
                case ' ' : i++ ; break;
                case '+' :
                case '-' : 
                case '(' : i ++ ; st2.push(c); break;
                case ')' : if(st2.peek() == '('){
                            st2.pop();
                            if(!st2.isEmpty() && st2.peek() != '('){
                                int val2 = st1.pop();
                                int val1 = st1.pop();
                                if(st2.peek() == '+'){
                                    st1.push(val1 + val2);
                                }else{
                                    st1.push(val1 - val2);
                                }
                                st2.pop();
                            }
                }else{
                    System.out.println("Something is wrong");
                }
                i ++;
                break;
                default : int num = c - '0'; i++;
                while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                if(!st2.isEmpty() && st2.peek() != '('){
                    int val = st1.pop();
                    char cc = st2.pop();
                    if(cc == '+'){
                        st1.push(val + num);
                    }else{
                        st1.push(val - num);
                    }
                }else{
                    st1.push(num);
                }
                break;
            }
        }
        return st1.peek();
    }
}