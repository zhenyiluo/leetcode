import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().calculate( "3+5 / 2 "));
    }

    public int calculate(String s) {
        Stack<Integer> st1 = new Stack<Integer>();
        Stack<Character> st2 = new Stack<Character>();
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                if (!st2.isEmpty() && (st2.peek() == '*' || st2.peek() == '/')) {
                    int val1 = st1.pop();
                    if (st2.peek() == '*') {
                        st1.push(val1 * num);
                    } else {
                        st1.push(val1 / num);
                    }
                    st2.pop();
                } else {
                    st1.push(num);
                }
                num = 0;
                st2.push(c);
            }
        }
        if (!st2.isEmpty() && (st2.peek() == '*' || st2.peek() == '/')) {
            int val1 = st1.pop();
            if (st2.peek() == '*') {
                st1.push(val1 * num);
            } else {
                st1.push(val1 / num);
            }
            st2.pop();
        } else {
            st1.push(num);
        }
        Stack<Integer> t1 = new Stack<Integer>();
        Stack<Character> t2 = new Stack<Character>();
            while(!st1.isEmpty()){
                t1.push(st1.pop());
            }
            while(!st2.isEmpty()){
                t2.push(st2.pop());
            }
            
            while (!t2.isEmpty()) {
                int val1 = t1.pop();
                int val2 = t1.pop();
                if (t2.peek() == '+') {
                    t1.push(val1 + val2);
                } else {
                    t1.push(val1 - val2);
                }
                t2.pop();
            }
        
        return t1.isEmpty() ? 0 : t1.peek();
    }
}