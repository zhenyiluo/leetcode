class Solution {
    public int minSwap(int[] A, int[] B) {
        int n = A.length;
        int[] toSwap = new int[n];
        int[] notSwap = new int[n];
        toSwap[0] = 1;
        for(int i = 1; i < n; i++){
            toSwap[i] = i;
            notSwap[i] = i;

            if(A[i-1] < A[i] && B[i-1] < B[i]){
                notSwap[i] = notSwap[i-1];
                toSwap[i] = toSwap[i-1] + 1;
            }

            if(A[i-1] < B[i] && B[i-1] < A[i]){
                notSwap[i] = Math.min(notSwap[i], toSwap[i-1]);
                toSwap[i] = Math.min(toSwap[i], notSwap[i-1] + 1);
            }

        }
        return Math.min(toSwap[n-1], notSwap[n-1]);
    }
}