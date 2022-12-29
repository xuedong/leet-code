class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a ,b) ->
            a[1] != b[1] ? a[1] - b[1] : a[2] - b[2]        
        );

        int[][] sortedTasks = new int[n][3];
        for (int i = 0; i < n; ++i) {
            sortedTasks[i][0] = tasks[i][0];
            sortedTasks[i][1] = tasks[i][1];
            sortedTasks[i][2] = i;
        }
        Arrays.sort(sortedTasks, (a, b) -> Integer.compare(a[0], b[0]));

        int[] results = new int[n];

        long curr = 0;
        int taskId = 0;
        int ansId = 0;
        while (taskId < n || !pq.isEmpty()) {
            if (pq.isEmpty() && curr < sortedTasks[taskId][0]) {
                curr = sortedTasks[taskId][0];
            }

            while (taskId < n && curr >= sortedTasks[taskId][0]) { 
                pq.offer(sortedTasks[taskId]);
                taskId++;
            }
            
            int[] task = pq.poll();
            int processTime = task[1];
            int id = task[2];
            
            curr += processTime; 
            results[ansId++] = id;
        }

        return results;
    }
}
