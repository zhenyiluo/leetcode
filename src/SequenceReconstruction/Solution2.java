class Solution {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        if(org == null || org.length == 0 || seqs == null || seqs.isEmpty()) return false;
        int n = org.length;
        int[] idx = new int[n+1];
        boolean[] pair = new boolean[n-1];
        HashSet<Integer> vis = new HashSet<>();
        for(int i = 0; i < n; i++){
            idx[org[i]] = i;
        }

        for(List<Integer> seq: seqs){
            for(int i = 0; i < seq.size(); i++){
                vis.add(seq.get(i));
                if(seq.get(i) <= 0 || seq.get(i) > n) return false;
                if(i > 0){
                    if(idx[seq.get(i-1)] >= idx[seq.get(i)]) return false;
                    if(idx[seq.get(i-1)] + 1 == idx[seq.get(i)]) pair[idx[seq.get(i-1)]] = true;
                }
            }
        }
        if(vis.size() != n) return false;
        for(int i = 0; i < n-1; i++){
            if(!pair[i]) return false;
        }
        return true;
    }
}