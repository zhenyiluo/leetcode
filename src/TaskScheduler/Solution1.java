class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(tasks == null || tasks.length == 0 || n < 0) return 0;
        int[] nums = new int[26];
        for(char task: tasks){
            nums[task - 'A'] ++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b-a));
        for(int num: nums){
            if(num != 0){
                pq.add(num);
            }
        }
        int cycle = n + 1;
        int ans = 0;
        while(!pq.isEmpty()){
            int work = 0;
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < cycle; i++){
                if(!pq.isEmpty()){
                    work++;
                    list.add(pq.poll());
                }
            }
            for(int val: list){
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