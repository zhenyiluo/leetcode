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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> ret = new ArrayList<>();
        for(Interval it : intervals){
            if(newInterval == null || it.end < newInterval.start){
                ret.add(it);
            }else if(it.start > newInterval.end){
                ret.add(newInterval);
                ret.add(it);
                newInterval = null;
            }else{
                newInterval.start = Math.min(newInterval.start, it.start);
                newInterval.end = Math.max(newInterval.end, it.end);
            }
        }
        if(newInterval != null) {
            ret.add(newInterval);
        }
        return ret;
    }
}