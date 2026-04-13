/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals,(a,b)->a.start-b.start);
        int right = 1;
        while(right<intervals.size()){
            if(intervals.get(right).start<intervals.get(right-1).end){
                return false;
            }
            right++;
        }
        return true;
    }
}
