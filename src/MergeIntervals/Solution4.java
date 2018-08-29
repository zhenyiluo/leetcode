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
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> ans = new ArrayList<>();
        if(intervals == null || intervals.size() == 0){
            return ans;
        }
        Collections.sort(intervals, (a, b) -> (a.start == b.start ? a.end - b.end : a.start - b.start));
        Interval prev = null;
        for(Interval cur : intervals){
            if(prev == null){
                prev = cur;
                continue;
            }
            if(cur.start > prev.end){
                ans.add(prev);
                prev = cur;
            }else{
                prev.end = Math.max(prev.end, cur.end);
            }
        }
        ans.add(prev);
        return ans;
    }
}