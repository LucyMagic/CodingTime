import java.util.*;
public class MergeIntervals {
	//**********************Solution 1**************//
	//Construct a new ArrayList to store the merged results
	public ArrayList<Interval> merge1(ArrayList<Interval> intervals) {
        ArrayList<Interval> mergedIntervals = new ArrayList<Interval>();
        if(intervals==null || intervals.isEmpty()) 
                return mergedIntervals;
                
        Comparator<Interval> byStart = new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                int cmp = i1.start - i2.start;
                if(cmp == 0) return 0;
                else if(cmp > 0) return 1;
                else return -1;
            }
        };        
        Collections.sort(intervals, byStart);        
        Interval prev = intervals.get(0);
        mergedIntervals.add(prev);
        for(Interval current : intervals){
            if(current.start <= prev.end){
                prev.end = Math.max(prev.end, current.end);
            }else{                
                mergedIntervals.add(current);
                prev = current;
            }
        }        
        return mergedIntervals;
    }
	//**********************Solution 1**************//
	//merge intervals in place
	public ArrayList<Interval> mergeInplace(ArrayList<Interval> intervals) {
        if(intervals==null || intervals.isEmpty()) 
            return intervals;
                
        Comparator<Interval> byStart = new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                int cmp = i1.start - i2.start;
                if(cmp == 0) return 0;
                else if(cmp > 0) return 1;
                else return -1;
            }
        };        
        Collections.sort(intervals, byStart);
        
        int mergedIndex = 0;
        for(int i = 1; i < intervals.size(); i++){
            Interval prev = intervals.get(mergedIndex);
            Interval current = intervals.get(i);
            if(current.start <= prev.end){
                prev.end = Math.max(prev.end, current.end);
            }else{
                mergedIndex++;
                intervals.set(mergedIndex, current);
            }
        }
        for(int i = intervals.size()-1; i > mergedIndex; i--){
            intervals.remove(i);
        }
        
        return intervals;
    }
	
	//*************Solution 3********************//
	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if(intervals==null || intervals.size()==0)
            return intervals;
        
        Comparator<Interval> byStart = new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                int cmp = i1.start - i2.start;
                if(cmp == 0)      return 0;
                else if(cmp > 0)  return 1;
                else              return -1;
            }  
        };
        Collections.sort(intervals, byStart);
        int mergedIndex = 0;
        Interval current = intervals.get(0);
        for(int i = 1; i < intervals.size(); i++){
            if(intervals.get(i).start <= current.end){
                current.end = Math.max(current.end, intervals.get(i).end);
            }else{
                mergedIndex++;
                current = intervals.get(i);
                intervals.set(mergedIndex, current);                                
            }
        }
        for(int j = intervals.size()-1; j > mergedIndex; j--){
            intervals.remove(intervals.size()-1);
        }      
        return intervals;
    }
    
    public class Interval {
    	 int start;
    	 int end;
    	 Interval() { start = 0; end = 0; }
    	 Interval(int s, int e) { start = s; end = e; }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeIntervals mi = new MergeIntervals();
		ArrayList<Interval> intervals = new ArrayList<Interval>();
		intervals.add(mi.new Interval(1,3));
//		intervals.add(mi.new Interval(1,4));
//		intervals.add(mi.new Interval(6,7));
//		intervals.add(mi.new Interval(8,9));
//		intervals.add(mi.new Interval(1,10));
		mi.merge1(intervals);
	}

}
