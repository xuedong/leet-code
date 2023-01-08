class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) return n;

        int ans = 1;
        for (int i = 0; i < n-1; i++) {
            int curr = 1;
            HashMap<List<Integer>, Integer> lines = new HashMap<>();
            int x1 = points[i][0];
            int y1 = points[i][1];
            for (int j = i + 1; j < n; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];
                List<Integer> slope = Arrays.asList(getSlope(x1, y1, x2, y2));
                System.out.println(lines.get(slope));
                lines.put(slope, lines.getOrDefault(slope, 1) + 1);
                curr = Math.max(lines.get(slope), curr);
            }

            ans = Math.max(ans, curr);
        }

        return ans;
    }

    private Integer[] getSlope(int x1, int y1, int x2, int y2) {
        Integer[] slope = new Integer[2];

        if (x1 == x2) {
            slope[0] = 0;
            slope[1] = 0;
            return slope;
        }
        if (y1 == y2) {
            slope[0] = Integer.MAX_VALUE;
            slope[1] = Integer.MAX_VALUE;
            return slope;
        }

        int deltaX = x1 - x2;
        int deltaY = y1 - y2;
        if (deltaX < 0){
            deltaX = - deltaX;
            deltaY = - deltaY;
        }

        int gcd = getGCD(deltaX, deltaY);
        slope[0] = deltaX / gcd;
        slope[1] = deltaY / gcd;
        return slope;
    }

    private int getGCD(int a, int b) {
        if (b == 0) return a;
        return getGCD(b, a % b);
    }
}
