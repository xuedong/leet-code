class Solution {
    public int orientation(int[] p, int[] q, int[] r) {
        return (q[0] - p[0]) * (r[1] - q[1]) - (q[1] - p[1]) * (r[0] - q[0]);
    }
    
    public int[][] outerTrees(int[][] trees) {
        int n = trees.length;
        if (n < 3) {
            return trees;
        }

        Arrays.sort(trees, new Comparator<int[]> () {
            public int compare(int[] p, int[] q) {
                return q[0] - p[0] == 0 ? q[1] - p[1] : q[0] - p[0];
            }
        });
        
        Stack<int[]> convexHull = new Stack<>();
        for (int i = 0; i < n; i++) {
            int[] curr = trees[i];
            while (convexHull.size() >= 2 && orientation(convexHull.get(convexHull.size()-2), convexHull.get(convexHull.size()-1), curr) < 0) {
                convexHull.pop();
            }
            convexHull.push(curr);
        }
        for (int i = n-2; i >= 0; i--) {
            int[] curr = trees[i];
            while (convexHull.size() >= 2 && orientation(convexHull.get(convexHull.size()-2), convexHull.get(convexHull.size()-1), curr) < 0) {
                convexHull.pop();
            }
            convexHull.push(curr);
        }

        HashSet<int[]> set = new HashSet<>(convexHull);
        return set.toArray(new int[set.size()][]);
    }
}
