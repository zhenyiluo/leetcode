class Solution2 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stInt = new Stack<>();
        for(String token :tokens){
            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){
                int val2 = stInt.pop();
                int val1 = stInt.pop();
                if(token.equals("+")){
                    stInt.push(val1 + val2);
                }else if(token.equals("-")){
                    stInt.push(val1 - val2);
                }else if(token.equals("*")){
                    stInt.push(val1 * val2);
                }else if(token.equals("/")){
                    stInt.push(val1 / val2);
                }
            }else{
                int val = Integer.valueOf(token);
                stInt.push(val);
            }
        }
        return stInt.peek();
    }
}