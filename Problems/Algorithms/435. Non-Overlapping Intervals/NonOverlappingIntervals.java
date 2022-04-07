class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        if (n <= 1) return 0;
        
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        
        int ans = 0;
        int i = 0;
        int j = 1;
        while (j < n) {
            if (intervals[j][0] < intervals[i][1]) {
                ans++;
            } else {
                i = j;
            }
            j++;
        }
        
        return ans;
    }
}

