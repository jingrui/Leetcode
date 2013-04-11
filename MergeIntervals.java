// Comparator Exmpale
// correct, running time O(logn)
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
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>(){
        	@Override
			public int compare(Interval arg0, Interval arg1) {
				if (arg0.start < arg1.start)
					return -1;
				if (arg0.start > arg1.start)
					return 1;
				// ----- the part matter for Large input time limit
				else {
		        	if (arg0.end < arg1.end)
			        	return -1;
			        else if (arg0.end > arg1.end)
			            return 1;
			        else
			        	return 0;
			    } 
			    //------------------------------------------------
			}
        });
        int i = 0;
        while( i < intervals.size()-1){
        	if (intervals.get(i).end >= intervals.get(i+1).start){
        		intervals.get(i).end = Math.max(intervals.get(i).end,intervals.get(i+1).end);
        		intervals.remove(i+1);
        		continue;
        	}
        	i++;        		
        }        
        return intervals;
    }
}

// Incorrect solution
// hash all the intervals
// counter example: 1-4, 5-6. In this way, we do not focus on interval but the integer point. Incorrect reason.
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
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> ret = new ArrayList<Interval>();
        if (intervals.isEmpty())
            return ret;
        HashMap<Integer,Integer> h = new HashMap<Integer,Integer>();
        int s = Integer.MAX_VALUE;
        int e = Integer.MIN_VALUE;
        for(int i = 0; i < intervals.size(); i++){
            s = Math.min(intervals.get(i).start,s);
            e = Math.max(intervals.get(i).end,e);
        }
        for(int i = s; i <= e; i++)
            h.put(i,0);
        
        for(int i = 0; i < intervals.size(); i++){
            for(int j = intervals.get(i).start; j <= intervals.get(i).end; j++)
                h.put(j,1);
        }
        boolean start = true;
        int sb = s;
        int i = s;
        while (i <= e){
            if (h.get(i) == 1){
                if (start == false){
                    sb = i;
                    start = true;
                }
            } else {
               if (start == true){
                   ret.add(new Interval(sb,i-1));
                   start = false;
               }
            }
            i++;
        }
        ret.add(new Interval(sb,e));
        return ret;
    }
}
