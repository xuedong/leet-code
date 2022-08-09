class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        int MOD = 1_000_000_007;
        
        int n = arr.length;
        Arrays.sort(arr);
        
        long[] dp = new long[n];
        Arrays.fill(dp, 1);
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0) {
                    int key = arr[i] / arr[j];
                    if (map.containsKey(key)) {
                        dp[i] = (dp[i] + dp[j] * dp[map.get(key)]) % MOD;
                    }
                }
            }
        }
        
        long ans = 0;
        for (long num : dp) {
            ans += num;
        }
        return (int) (ans % MOD);
    }
}

