class Solution {
    public int countDigitOne(int n) {
        int ans = 0;
        
        for (long i = 1; i <= n; i *= 10) {
            long div = i * 10;
            ans += (n / div) * i + Math.min(Math.max(n % div - i + 1, 0), i);
        }
        
        return ans;
    }
}

