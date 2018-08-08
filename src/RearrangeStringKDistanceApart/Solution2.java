class Solution {
    public String rearrangeString(String s, int k) {
        if(s == null || s.length() == 0 || k < 0) return "";
        if(k == 0) return s;
        int[] nums = new int[26];
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            nums[c - 'a']++;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] != b[1] ? b[1] - a[1] : a[0] - b[0]));
        for(int i = 0; i < 26; i++){
            if(nums[i] != 0){
                pq.add(new int[]{i, nums[i]});
            }
        }
        StringBuilder sb = new StringBuilder();
        Queue<int[]> waitQueue = new LinkedList<>();
        while(!pq.isEmpty()){
            int[] item = pq.poll();
            item[1] --;
            sb.append((char)(item[0] + 'a'));
            waitQueue.add(item);

            if(waitQueue.size() < k){
                continue;
            }

            int[] front = waitQueue.poll();
            if(front[1] > 0){
                pq.add(front);
            }
        }
        return sb.length() == s.length() ? sb.toString() : "";
    }
}