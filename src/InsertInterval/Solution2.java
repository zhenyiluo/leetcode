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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> ret = new ArrayList<>();
        if(intervals == null || intervals.size() == 0){
            if(newInterval != null){
                ret.add(newInterval);
                return ret;
            }
        }

        for(Interval interval : intervals){
            if(newInterval == null){
                ret.add(interval);
                continue;
            }
            if(newInterval.end < interval.start){
                ret.add(newInterval);
                ret.add(interval);
                newInterval = null;
            }else if(newInterval.start > interval.end){
                ret.add(interval);
            }else{
                newInterval.start = Math.min(interval.start, newInterval.start);
                newInterval.end = Math.max(interval.end, newInterval.end);
            }
        }
        if(newInterval != null) ret.add(newInterval);
        return ret;
    }
}