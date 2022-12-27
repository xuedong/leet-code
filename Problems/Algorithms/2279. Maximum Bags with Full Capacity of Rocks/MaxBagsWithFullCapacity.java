class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;
        int[] adjustedCap = new int[n];

        for (int i = 0; i < n; i++) {
            adjustedCap[i] = capacity[i] - rocks[i];
        }

        Arrays.sort(adjustedCap);
        
        int rest = additionalRocks;
        int ans = 0;
        int i = 0;
        
        while (rest > 0 && i < n) {
            if (rest >= adjustedCap[i]) {
                ans++;
            }
            rest -= Math.min(rest, adjustedCap[i]);
            i++;
        }

        return ans;
    }
}
