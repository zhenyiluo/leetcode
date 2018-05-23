class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] num = new int[26];
        for(int i = 0; i < tasks.length; i++){
            num[tasks[i] - 'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b-a));
        for(int i = 0; i < 26; i++){
            if(num[i] != 0){
                pq.add(num[i]);
            }
        }
        int ans = 0;
        int cycle = n + 1;
        while(!pq.isEmpty()){
            int work = 0;
            List<Integer> tmp = new ArrayList<>();
            for(int i = 0; i < cycle; i++){
                if(!pq.isEmpty()){
                    work++;
                    tmp.add(pq.poll());
                }
            }
            for(int val : tmp){
                if(val > 1){
                    pq.add(val-1);
                }
            }
            if(pq.isEmpty()){
                ans += work;
            }else{
                ans += cycle;
            }
        }
        return ans;
    }
}