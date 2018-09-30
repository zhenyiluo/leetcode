class Solution {
    public int[][] reconstructQueue(int[][] people) {
        HashSet<int[]> frontSet = new HashSet<>();
        HashSet<int[]> waitSet = new HashSet<>();
        int n = people.length;
        for(int[] p: people){
            if(p[1] == 0){
                frontSet.add(new int[]{p[0], p[1]});
            }else{
                waitSet.add(new int[]{p[0], p[1], p[1]});
            }
        }

        int[][] ans = new int[n][2];
        int index = 0;
        while(index < n){
            int[] pair = retrieveSmallest(frontSet);
            int height = pair[0];
            ans[index++] = pair;
            process(height, frontSet, waitSet);
        }
        return ans;
    }

    private int[] retrieveSmallest(HashSet<int[]> set){
        int min = Integer.MAX_VALUE;
        int[] ans = null;
        for(int[] pair : set){
            if(pair[0] < min){
                min = pair[0];
                ans = pair;
            }
        }
        set.remove(ans);
        return ans;
    }

    private void process(int height, HashSet<int[]> frontSet, HashSet<int[]> waitSet){
        HashSet<int[]> toBeRemoved = new HashSet<>();
        for(int[] pair: waitSet){
            if(pair[0] <= height){
                pair[2] --;
                if(pair[2] == 0){
                    frontSet.add(new int[]{pair[0], pair[1]});
                    toBeRemoved.add(pair);
                }
            }
        }
        for(int[] pair: toBeRemoved){
            waitSet.remove(pair);
        }
    }
}