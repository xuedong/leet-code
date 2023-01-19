class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int[] prefixes = new int[n];

        int prefix = 0;
        for (int i = 0; i < n; i++) {
            prefix += nums[i];
            prefixes[i] = (prefix % k + k) % k;
        }

        int[] rests = new int[k];
        for (int i = 0; i < n; i++) {
            rests[prefixes[i]]++;
        }

        int ans = rests[0];
        for (int j = 1; j < k; j++) {
            ans += rests[j] * (rests[j] - 1) / 2;
        }
        ans += rests[0] * (rests[0] - 1) / 2;

        return ans;
    }
}
