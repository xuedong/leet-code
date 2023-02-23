class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        
        int[][] projects = new int[n][2];
        for (int i = 0; i < n; i++) {
            projects[i] = new int[]{capital[i], profits[i]};
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        Arrays.sort(projects, (a, b) -> Integer.compare(a[0], b[0]));

        int i = 0;
        for (int j = 0; j < k; j++) {
            while(i < n && projects[i][0] <= w){
                pq.add(projects[i++][1]);
            }

            if (pq.isEmpty()) {
                break;
            }

            w += pq.poll();
        }
            
        return w;
    }
}
