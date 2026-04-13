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
        for(Interval i : intervals){
            start.add(i.start);
            end.add(i.end);
        }
        Collections.sort(start);
        Collections.sort(end);
        int res = 0;
        int i = 0;
        int j = 0;
        int count = 0;
        while(i<start.size()){
            if(start.get(i)<end.get(j)){
                i++;
                count++;
            }else{
                j++;
                count--;
            }
            res = Math.max(res,count);
        }
        return res;
    }
}
