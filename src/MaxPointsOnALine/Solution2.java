/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
class Solution {
    public int maxPoints(Point[] points) {
        if(points == null || points.length == 0) return 0;
        if(points.length == 1) return 1;
        int len = points.length;
        int ans = 0;
        for(int i = 0; i < len; i++){
            HashMap<String, Integer> hm = new HashMap<>();
            int duplicate = 1;
            Point p1 = points[i];
            for(int j = i+1; j < len; j++){
                Point p2 = points[j];
                if(p1.x == p2.x && p1.y == p2.y){
                    duplicate++;
                    continue;
                }
                int dx = p1.x - p2.x;
                int dy = p1.y - p2.y;
                int gcd = gcd(dx, dy);
                dx /= gcd;
                dy /= gcd;
                String key = dx + "#" + dy;
                hm.put(key, hm.getOrDefault(key, 0) + 1);
            }
            ans = Math.max(ans, duplicate);
            for(int val : hm.values()){
                ans = Math.max(ans, duplicate + val);
            }
        }
        return ans;
    }

    private int gcd(int a, int b){
        return b == 0 ? a : gcd(b, a % b);
    }
}