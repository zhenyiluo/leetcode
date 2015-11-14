public class Solution1 {
     public boolean verifyPreorder(int[] preorder) {
        if(preorder == null || preorder.length == 0){
            return true;
        }
        int low = Integer.MIN_VALUE;
        Stack<Integer> st = new Stack<Integer>();
        for(int p : preorder){
            if(p < low){
                return false;
            }
            while(!st.isEmpty() && p > st.peek()){
                low = st.pop();
            }
            st.push(p);
        }
        return true;
    }
}