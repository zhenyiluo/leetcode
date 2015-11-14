public class Solution {
     public boolean verifyPreorder(int[] preorder) {
        if(preorder == null || preorder.length == 0){
            return true;
        }

        return dfs(preorder, 0, preorder.length -1);
    }

    private boolean dfs(int[] preorder, int start, int end){
        if(start >= end){
            return true;
        }

        int val = preorder[start];

        int i = start + 1;
        while(i <= end && preorder[i] < val){
            i++;
        }
        int j = i;
        while(j <= end && preorder[j] > val){
            j++;
        }

        if(j <= end){
            return false;
        }
        return dfs(preorder, start +1, i-1) && dfs(preorder, i, end);
    }
}