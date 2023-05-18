class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] exists = new boolean[n];
        for (List<Integer> edge : edges) {
            exists[edge.get(1)] = true;
        }

        List<Integer> ans = new ArrayList();
        for (int i = 0; i < n; i++) {
            if (!exists[i]) {
                ans.add(i);
            }
        }

        return ans;
    }
}
