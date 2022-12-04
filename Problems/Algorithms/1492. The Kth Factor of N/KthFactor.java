class Solution {
    public int kthFactor(int n, int k) {
        int sqrt = (int) Math.sqrt(n);
        for (int i = 1; i <= sqrt; i++) {
            if (n % i == 0) {
                if (--k == 0) {
                    return i;
                }
            }
        }
        for (int i = sqrt; i >= 1; i--) {
            if (i * i == n) continue;
            if (n % i == 0) {
                if (--k == 0) {
                    return n / i;
                }
            }
        }
        return -1;
    }
}
