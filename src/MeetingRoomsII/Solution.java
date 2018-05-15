/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) return 0;
        ArrayList<int[]> pairs = new ArrayList<>();
        for(Interval interval : intervals){
            pairs.add(new int[]{interval.start, 1});
            pairs.add(new int[]{interval.end, -1});
        }

        Collections.sort(pairs, (a, b) -> {
            if(a[0] != b[0]){
                return a[0] - b[0];
            }else{
                return a[1] - b[1];
            }
        });

        int ret = 0;
        int cnt = 0;
        for(int[] pair : pairs){
            if(pair[1] > 0){
                cnt ++;
            }else{
                cnt --;
            }
            ret = Math.max(ret, cnt);
        }
        return ret;
    }
}