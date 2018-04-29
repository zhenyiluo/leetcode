/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution2 {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> ret = new ArrayList<>();
        Collections.sort(intervals, (a, b) -> (a.start - b.start));
        for(Interval interval: intervals){
            if(ret.isEmpty() || interval.start > ret.get(ret.size() -1).end){
                ret.add(interval);
            }else{
                Interval cur = ret.get(ret.size() -1);
                cur.end = Math.max(cur.end, interval.end);
            }
        }
        return ret;
    }
}