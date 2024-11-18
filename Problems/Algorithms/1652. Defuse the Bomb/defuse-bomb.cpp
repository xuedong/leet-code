#include <vector>

using namespace std;

class Solution {
public:
    vector<int> decrypt(vector<int>& code, int k) {
        int n = code.size();

        vector<int> result(n, 0);
        int start = 1, end = k, sum = 0;
        if (k < 0) {
            start = n + k;
            end = n - 1;
        }

        for (int i = start; i <= end; i++) {
            sum += code[i];
        }
        for (int i = 0; i < n; i++) {
            result[i] = sum;
            sum -= code[start % n];
            sum += code[(end+1) % n];
            start++;
            end++;
        }

        return result;
    }
};
