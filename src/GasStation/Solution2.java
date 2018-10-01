class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int n = gas.length;
        for(int i = 0; i < n; i++){
            total += gas[i] - cost[i];
        }
        if(total < 0){
            return -1;
        }
        int tmp = 0;
        int ans = 0;
        for(int i = 0; i < n; i++){
            tmp += gas[i] - cost[i];
            if(tmp < 0){
                ans = i + 1;
                tmp = 0;
            }
        }
        return ans;
    }
}