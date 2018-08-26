class Solution {
    public boolean isReflected(int[][] points) {
        if(points == null || points.length == 0) return true;
        if(points.length == 1) return true;
        HashSet<String> hs = new HashSet<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int[] p : points){
            min = Math.min(min, p[0]);
            max = Math.max(max, p[0]);
            String s = p[0] + "#" + p[1];
            hs.add(s);
        }
        int sum = min + max;
        for(int[] p: points){
            String s = (sum - p[0]) + "#" + p[1];
            if(!hs.contains(s)){
                return false;
            }
        }
        return true;
    }
}