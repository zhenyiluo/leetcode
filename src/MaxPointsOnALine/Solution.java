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
        int ret = 0;
        for(int i = 0; i < points.length; i++){
            HashMap<HashMap<Integer, Integer>, Integer> hm = new HashMap<>();
            int duplicate = 1;
            for(int j = i+1; j < points.length; j++){
                if(points[i].x == points[j].x && points[i].y == points[j].y){
                    duplicate ++;
                    continue;
                }
                int dx = points[i].x - points[j].x;
                int dy = points[i].y - points[j].y;
                int gcd = gcd(dx, dy);
                int t1 = dx / gcd;
                int t2 = dy / gcd;
                HashMap<Integer, Integer> tmp = new HashMap<>();
                tmp.put(t1, t2);
                hm.put(tmp, hm.getOrDefault(tmp, 0) + 1);
            }
            ret = Math.max(ret, duplicate);
            for(int val: hm.values()){
                ret = Math.max(ret, val + duplicate);
            }
        }
        return ret;
    }

    private int gcd(int a, int b){
        return b == 0 ? a: gcd(b, a % b);
    }
}