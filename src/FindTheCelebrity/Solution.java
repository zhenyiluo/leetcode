/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        if(n <= 1){
            return -1;
        }
        
        int num = helper(0, n-1);
        
        if(num == -1){
            return -1;
        }
        
        for(int i = 0; i < n; i++){
            if(i == num){
                continue;
            }
            if(knows(num, i) || !knows(i, num)){
                return -1;
            }
        }
        return num;
    }
    
    private int helper(int start, int end){
        if(start > end){
            return -1;
        }
        
        if(start == end){
            return start;
        }
        
        int mid = start + ((end - start)>> 1);
        
        int  left = helper(start, mid);
        int right = helper(mid+1, end);
        
        if(left == -1 && right == -1){
            return -1;
        }else if(left == -1){
            return right;
        }else if(right == -1){
            return left;
        }else{
            boolean flag1 = knows(left, right);
            boolean flag2 = knows(right, left);
            if(!(flag1 ^ flag2)){
                return -1;
            }else if(flag1){
                return right;
            }else{
                return left;
            }
        }
    }
}