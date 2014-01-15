/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        int i = 0;
        while( i < intervals.size()){
            if (newInterval.start > intervals.get(i).end)
                i++;
            else if(newInterval.end < intervals.get(i).start){
                intervals.add(i,newInterval);
                return intervals;
            }
            else{
                newInterval.start = Math.min(newInterval.start,intervals.get(i).start);
                newInterval.end = Math.max(newInterval.end,intervals.get(i).end);
                intervals.remove(i);
            }
        }
        intervals.add(i,newInterval);
        return intervals;
    }
}
