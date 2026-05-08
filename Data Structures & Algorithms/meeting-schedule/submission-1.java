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
        // Initialize last end time and sort intervals by start time
        int lastEnd = 0;
        intervals.sort((interval1, interval2) -> interval1.start - interval2.start);

        // Loop through all intervals
        for (Interval time : intervals) {
            // Return false if the start is more than the last end time, update last end time if not
            if (lastEnd > time.start) return false;
            else lastEnd = time.end;
        }

        // Assuming all intervals are valid, return true
        return true;
    }
}
