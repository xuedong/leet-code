class Solution {
    public int uniquePaths(int m, int n) {
        if (m > n) {
            int temp = m;
            m = n;
            n = temp;
        }
        return ncr(m+n-2, m-1);
    }
    
    private int ncr(int m, int n) {
        long ans = 1;
        for (int i = 1; i <= n; i++) {
            ans = ans * (m-i+1) / i;
        }
        return (int) ans;
    }
}

