class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n <= 1) return intervals;
        
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        List<int[]> result = new ArrayList<>();
        
        int i = 0;
        int[] curr = intervals[0];
        while (i < n-1) {
            int[] next = intervals[i+1];
            
            if (next[0] > curr[1]) {
                result.add(curr);
                curr = new int[]{next[0], next[1]};
            } else {
                curr = new int[]{curr[0], Math.max(next[1], curr[1])};
            }
            i++;
        }
        result.add(curr);
        
        return result.toArray(new int[result.size()][]);
    }
}

