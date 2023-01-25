class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int n = queries.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int[] query = queries[i];
            int curr = 0;
            for (int[] point : points) {
                int dist = (point[0] - query[0]) * (point[0] - query[0]) + (point[1] - query[1]) * (point[1] - query[1]);
                if (dist <= query[2] * query[2]) curr++;
            }
            ans[i] = curr;
        }

        return ans;
    }
}
