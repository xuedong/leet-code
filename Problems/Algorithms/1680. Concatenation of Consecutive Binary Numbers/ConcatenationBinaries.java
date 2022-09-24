class Solution {
    public int concatenatedBinary(int n) {
        long modulo = (long) (1e9 + 7);

        long result = 0;
        int digits = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i-1)) == 0) {
                digits++;
            }

            result = ((result << digits) + i) % modulo;
        }

        return (int) result;
    }
}
