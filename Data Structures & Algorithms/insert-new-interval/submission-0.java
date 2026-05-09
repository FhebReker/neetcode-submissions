class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> newIntervals = new ArrayList<>();
        
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            newIntervals.add(intervals[i]);
            i++;
        }

        int[] combinedInterval = newInterval;
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            combinedInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            combinedInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        newIntervals.add(combinedInterval);

        while (i < intervals.length) {
            newIntervals.add(intervals[i]);
            i++;
        }

        return newIntervals.toArray(new int[newIntervals.size()][]);
    }
}
