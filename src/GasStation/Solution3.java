class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int n = gas.length;
        for(int i = 0; i < n; i++){
            totalGas += gas[i];
            totalCost += cost[i];
        }
        if(totalGas < totalCost) return -1;
        int ans = 0;
        int remain = 0;
        for(int i = 0; i < n; i++){
            remain += gas[i] - cost[i];
            if(remain < 0){
                ans = i+1;
                remain = 0;
            }
        }
        return ans;
    }
}