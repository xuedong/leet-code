class Solution {
    public int numSquares(int n) {
        if (n <= 0) return 0;
        
        int[] results = new int[n+1];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i * i < n+1; i++) {
            if (i * i == n) {
                return 1;
            }
            results[i*i] = 1;
            queue.offer(i*i);
        }
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int i = 1; i * i + curr <= n; i++) {
                if (i * i + curr == n) {
                    return results[curr] + 1;
                } else if (i * i + curr < n && results[i*i+curr] == 0) {
                    results[i*i+curr] = results[curr] + 1;
                    queue.offer(i*i+curr);
                } else if (i * i + curr > n) { 
                    break;
                }
            }
        }
        
        return 0;
    }
}

