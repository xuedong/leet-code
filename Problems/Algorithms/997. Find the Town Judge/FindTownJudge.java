class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] scores = new int[n+1];

        for (int i = 0; i < trust.length; i++) {
            scores[trust[i][0]]--;
            scores[trust[i][1]]++;
        }

        int i = 1;
        for (; i <= n; i++) {
            if (scores[i] == n - 1) {
                break;
            }
        }

        return i <= n ? i : -1;
    }
}

