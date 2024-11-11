#include <vector>
#include <cmath>

using namespace std;

class Solution {
public:
    bool checkPrime(int x) {
        for (int i = 2; i <= sqrt(x); i++) {
            if (x % i == 0) {
                return 0;
            }
        }
        return 1;
    }

    bool primeSubOperation(vector<int>& nums) {
        int maximum = *max_element(nums.begin(), nums.end());

        vector<int> primes(maximum + 1, 0);
        for (int i = 2; i <= maximum; i++) {
            if (checkPrime(i)) {
                primes[i] = i;
            } else {
                primes[i] = primes[i-1];
            }
        }

        for (int i = 0; i < nums.size(); i++) {
            int bound;

            if (i == 0) {
                bound = nums[0];
            } else {
                bound = nums[i] - nums[i-1];
            }

            if (bound <= 0) {
                return 0;
            }

            int prev = primes[bound-1];
            nums[i] = nums[i] - prev;
        }

        return 1;
    }
};
