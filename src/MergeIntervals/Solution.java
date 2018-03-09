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
        if(intervals == null) return new ArrayList<>();
        Stack<Interval> stack = new Stack<>();
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        for(Interval it: intervals){
            if(stack.isEmpty() || it.start > stack.peek().end){
                stack.push(it);
            }else{
                stack.peek().end = Math.max(stack.peek().end, it.end);
            }
        }

        return new ArrayList<>(stack);
    }
}