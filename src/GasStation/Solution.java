class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        for(int g : gas){
            totalGas += g;
        }
        for(int c : cost){
            totalCost += c;
        }
        if(totalGas < totalCost) return -1;
        int n = gas.length;
        for(int i = 0; i < n; i++){
            if(gas[i] >= cost[i]){
                int tmpG = 0;
                boolean canComplete = true;
                for(int j = 0; j < n; j++){
                    tmpG += gas[(i + j) % n] - cost[(i + j) % n];
                    if(tmpG < 0){
                        canComplete = false;
                        break;
                    }
                }
                if(canComplete){
                    return i;
                }
            }
        }
        return -1;
    }
}