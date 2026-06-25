import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        
        // Step 1: Sort by start value
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // Step 2: Start with the first interval
        List<int[]> result = new ArrayList<>();
        int start = intervals[0][0];
        int end   = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int currStart = intervals[i][0];
            int currEnd   = intervals[i][1];

            if (currStart <= end) {
                // Overlap → stretch the end if needed
                end = Math.max(end, currEnd);
            } else {
                // No overlap → save current interval, move to next
                result.add(new int[]{start, end});
                start = currStart;
                end   = currEnd;
            }
        }

        // Step 3: Don't forget to add the last interval
        result.add(new int[]{start, end});

        return result.toArray(new int[result.size()][]);
    }
}