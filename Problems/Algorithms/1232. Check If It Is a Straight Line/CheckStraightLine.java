class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int x1 = coordinates[0][0];
        int y1 = coordinates[0][1];
        int x2 = coordinates[1][0];
        int y2 = coordinates[1][1];
        
        if (x1 == x2) {
            for (int[] coord : coordinates) {
                if (coord[0] != x1) return false;
            }
            return true;
        }
        
        double k = (double) (y2 - y1) / (double) (x2 - x1);
        double b = (double) (y1*x2 - y2*x1) / (double) (x2 - x1);
        for (int[] coord : coordinates) {
            if (k * (double) coord[0] + b != (double) coord[1]) return false;
        }
        return true;
    }
}
