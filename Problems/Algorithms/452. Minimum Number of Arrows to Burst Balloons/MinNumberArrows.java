class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;

        Arrays.sort(points, (point1, point2) -> {
            if (point1[1] == point2[1]) return 0;
            if (point1[1] < point2[1]) return -1;
            return 1;
        });

        int ans = 1;
        int firstEnd = points[0][1];
        for (int[] point: points) {
            if (firstEnd < point[0]) {
                ans++;
                firstEnd = point[1];
            }
        }

        return ans;
    }
}
