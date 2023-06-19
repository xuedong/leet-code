class Solution {
    public int largestAltitude(int[] gain) {
        int ans = 0;
        int curr = 0;
        for (int step : gain) {
            curr += step;
            ans = Math.max(ans, curr);
        }

        return ans;
    }
}
