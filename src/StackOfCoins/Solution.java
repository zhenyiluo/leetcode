import java.util.*;
public class Solution {
    public static void main(String[] args){
        Stack<Integer>[] stacks = new Stack[2];
        stacks[0] = new Stack<>();
        stacks[0].push(3);
        stacks[0].push(700);
        stacks[0].push(4);
        stacks[0].push(1);

        stacks[1] = new Stack<>();
        stacks[1].push(6);
        stacks[1].push(10);
        stacks[1].push(5);

        System.out.println(new Solution().getMax(stacks, 3));
    }
    public int getMax(Stack<Integer>[] stacks, int n){
        if(stacks == null || stacks.length == 0 || n <= 0){
            return 0;
        }

        int[] dp = new int[n+1];
        int len = stacks.length;
        for(int i = 0; i < len; i++){
            int sum = 0;
            int size = stacks[i].size();
            for(int j = 0; j <= size; j++){
                if(j != 0){
                    sum += stacks[i].pop();
                }
                for(int k = n; k >= j; k--){
                    dp[k] = Math.max(dp[k], dp[k-j] + sum);
                }
            }
        }
        return dp[n];
    }
}

