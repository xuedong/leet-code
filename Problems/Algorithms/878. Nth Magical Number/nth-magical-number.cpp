#include <iostream>
#include <algorithm>

class Solution {
public:
    int nthMagicalNumber(int n, int a, int b) {
        int MOD = 1e9 + 7;
        int lcm = a * b / gcd(a, b);

        long left = -1;
        long right = (long) n * std::min(a, b) + 1;
        while (right - left > 1) {
            long mid = left + (right - left) / 2;

            if (mid / a + mid / b - mid / lcm < n) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return (int) (right % MOD);
    }

    int gcd(int x, int y) {
        if (x == 0) {
            return y;
        }
        return gcd(y % x, x);
    }
};
