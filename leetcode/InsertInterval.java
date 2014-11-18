import java.util.*;
public class InsertInterval {
	//**********************Solution 1**************//
    public ArrayList<Interval> insert1(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> ret = new ArrayList<Interval>();
        if(intervals == null || newInterval == null) return ret;
        //intervals before newInterval
        int i = 0;
        //remember the boundary check
        //can be improved with binary search for position
        while(i<intervals.size() && newInterval.start > intervals.get(i).end){
            ret.add(intervals.get(i));
            i++;
        }
        //overlapping intervals
        //we update the start and end values of the newInterval to avoid the case when newInterval
        //is the last one to be added to the list, not overlapping with any other interval
        while(i<intervals.size() && newInterval.end >= intervals.get(i).start){
            newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
            newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
            i++;
        }
        ret.add(newInterval);        
        
        //remaining non-overlapping intervals
        while(i<intervals.size()){
            ret.add(intervals.get(i));
            i++;
        }
        
        return ret;
    }
  //**********************Solution 2**************//
    //directly update intervals given in the argument
    public ArrayList<Interval> insert2(ArrayList<Interval> intervals, Interval newInterval) {
        if(intervals==null || newInterval==null) return null;
 
        int pos = findInsertPos(intervals, newInterval.start);
        if(pos == intervals.size()){//add to the end
            intervals.add(newInterval);           
        }else if(newInterval.end < intervals.get(pos).start){//not overlapping
             intervals.add(pos, newInterval);
        }else{//overlapping, needs merging
             //find all intervals needs merging
             int start = pos;
             while(pos<intervals.size() && newInterval.end >= intervals.get(pos).start){
                 newInterval.start = Math.min(newInterval.start, intervals.get(pos).start);
                 newInterval.end = Math.max(newInterval.end, intervals.get(pos).end);
                 pos++;
             }
             intervals.set(start++, newInterval);
             //move the rest of the intervals to front
             while(pos < intervals.size()){
                intervals.set(start++, intervals.get(pos++));
             }   
             //clean up the intervals
             for(int i = intervals.size()-1; i >= start; i--){
                 intervals.remove(i);
             }
        }
        return intervals;
    }
    private int findInsertPos(ArrayList<Interval> intervals, int target){
        //non overlapping => no dups
        //find the first element equals or greater than target
        int lo = 0, hi = intervals.size()-1;
        int bestSoFar = -1;
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            int endVal = intervals.get(mid).end;
            if(endVal == target){
                return mid;
            }else if(endVal > target){
                bestSoFar = mid;
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }
        //all elements are smaller
        if(bestSoFar == -1) return intervals.size();
        return bestSoFar;
    }

    public class Interval {
   	 int start;
   	 int end;
   	 Interval() { start = 0; end = 0; }
   	 Interval(int s, int e) { start = s; end = e; }
   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InsertInterval ii = new InsertInterval();
		ArrayList<Interval> intervals = new ArrayList<Interval>();
		intervals.add(ii.new Interval(1, 5));
		intervals.add(ii.new Interval(6, 8));
		Interval newInterval = ii.new Interval(5, 6);
		ii.insert1(intervals, newInterval);
	}

}
