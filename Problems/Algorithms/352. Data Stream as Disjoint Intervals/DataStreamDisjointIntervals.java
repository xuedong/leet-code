class SummaryRanges {
    private TreeMap<Integer, Integer> intervals;

    public SummaryRanges() {
        intervals = new TreeMap<>();
    }
    
    public void addNum(int value) {
        int left = value, right = value;
        
        Map.Entry<Integer, Integer> leftEntry = intervals.floorEntry(value);
        if (leftEntry != null) {
            int prev = leftEntry.getValue();
            
            if (prev >= value) {
                return;
            }
            
            if (prev == value - 1) {
                left = leftEntry.getKey();
            }
        }
        
        Map.Entry<Integer, Integer> rightEntry = intervals.higherEntry(value);
        if (rightEntry != null) {
            int next = rightEntry.getValue();

            if (rightEntry.getKey() == value + 1) {
                right = next;
                intervals.remove(value+1);
            }
        }

        intervals.put(left, right);
    }
    
    public int[][] getIntervals() {
        int[][] results = new int[intervals.size()][2];
        
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : intervals.entrySet()) {
            results[i][0] = entry.getKey();
            results[i++][1] = entry.getValue();
        }
        
        return results;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */