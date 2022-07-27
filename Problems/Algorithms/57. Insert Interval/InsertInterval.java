class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        if (n == 0) return new int[][]{newInterval};
        
        List<int[]> result = new ArrayList<>();
        
        int start = newInterval[0], end = newInterval[1];
        int i = 0;
        while (i < n) {
            if (end < intervals[i][0]) {
                result.add(newInterval);
                break;
            }
            
            if (start > intervals[i][1]) {
                result.add(intervals[i]);
                i++;
            } else {
                int j = i;
                while (j < n && end >= intervals[j][0]) {
                    j++;
                }
                result.add(new int[]{Math.min(start, intervals[i][0]), Math.max(end, intervals[j-1][1])});
                i = j;
                break;
            }
        }
        
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }
        
        if (start > intervals[n-1][1]) {
            result.add(newInterval);
        }
        
        return result.toArray(new int[result.size()][]);
    }
}

