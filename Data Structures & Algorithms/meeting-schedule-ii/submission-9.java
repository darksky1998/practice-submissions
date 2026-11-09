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
    public int minMeetingRooms(List<Interval> intervals) {
        List<Integer> start = new ArrayList<>();
        List<Integer> end = new ArrayList<>();
        for(Interval interval: intervals){
            start.add(interval.start);
            end.add(interval.end);
        }
        Collections.sort(start);
        Collections.sort(end);
        int s = 0, e = 0,count = 0, res = 0;
        while(s<start.size() && e<end.size()){
            if(start.get(s)<end.get(e)){
                count++;
                s++;
            }else{
                count--;
                e++;
            }
            res = Math.max(res,count);
        }
        return res;
    }
}
