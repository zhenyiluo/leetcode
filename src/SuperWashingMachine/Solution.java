class Solution {
    public int findMinMoves(int[] machines) {
        int sum = 0;
        for(int machine: machines){
            sum += machine;
        }
        int n = machines.length;
        if(sum % n != 0) return -1;
        int avg = sum / n;
        int[] leftSum = new int[n];
        int[] rightSum = new int[n];
        for(int i = 1; i < n; i++){
            leftSum[i] = leftSum[i-1] + machines[i-1];
        }
        for(int i = n-2; i >= 0; i--){
            rightSum[i] = rightSum[i+1] + machines[i+1];
        }
        int ret = 0;
        for(int i = 0; i < n; i++){
            int expectLeft = i * avg;
            int expectRight = (n - i -1) * avg;
            int left = 0;
            int right = 0;
            if(expectLeft > leftSum[i]) {
                left = expectLeft - leftSum[i];
            }
            if(expectRight > rightSum[i]){
                right = expectRight - rightSum[i];
            }
            ret = Math.max(ret, left + right);
        }
        return ret;
    }
}