class Solution {
    public int superPow(int a, int[] b) {
        if (a % 1337 == 0) return 0;
        
        int p = 0;
        for (int i : b) {
            p = (p * 10 + i) % 1140;
        }

        if (p == 0) p += 1140;
        return pow(a, p, 1337);
    }

    private int pow(int a, int b, int mod) {
        a %= mod;
        int ans = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                ans = ans * a % mod;
            }
            a = a * a % mod;
            b >>= 1;
        }
        return ans;
    }
}
