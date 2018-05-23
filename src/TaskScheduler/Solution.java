class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] num = new int[26];
        for(int i = 0; i < tasks.length; i++){
            num[tasks[i] - 'A']++;
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < 26; i++){
            max = Math.max(max, num[i]);
        }

        int numOfMax = 0;
        for(int i = 0; i < 26; i++){
            if(num[i] == max){
                numOfMax ++;
            }
        }
        return Math.max(tasks.length, (max -1) * (n+1) + numOfMax);
    }
}