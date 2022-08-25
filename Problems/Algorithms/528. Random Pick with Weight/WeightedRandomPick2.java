class Solution {

    Random random;
    int[] freqSums;

    public Solution(int[] w) {
        this.random = new Random();
        this.freqSums = new int[w.length];
        for (int i = 0; i < w.length; i++) {
            if (i == 0) {
                this.freqSums[i] = w[i];
            } else {
                this.freqSums[i] = this.freqSums[i - 1] + w[i];
            }
        }
    }

    public int pickIndex() {
        int n = this.freqSums.length;
        int randomNum = this.random.nextInt(this.freqSums[n - 1]) + 1;

        int low = -1;
        int high = n;
        while (high - low > 1) {
            int mid = low + (high - low) / 2;
            if (this.freqSums[mid] >= randomNum) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return high;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */