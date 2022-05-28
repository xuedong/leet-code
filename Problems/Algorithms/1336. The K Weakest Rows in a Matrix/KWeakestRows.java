class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getKey() == b.getKey() ? a.getValue() - b.getValue() : a.getKey() - b.getKey());
        
        int n = mat.length;
        int m = mat[0].length;
        
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = m;
            int num = m;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (mat[i][mid] == 0) {
                    num = mid;
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            
            pq.add(new Pair(num, i));
        }
        
        int[] results = new int[k];
        for (int i = 0; i < k; i++) {
            results[i] = pq.poll().getValue();
        }
        return results;
    }
}

