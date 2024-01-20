#include <vector>
#include <stack>

using namespace std;

const int MOD = 1e9 + 7;

class Solution {
public:
    int sumSubarrayMins(vector<int>& arr) {
        int n = arr.size();
        vector<int> left(n, -1);
        vector<int> right(n, n);

        stack<int> st;
        for (int i = 0; i < n; i++) {
            while (!st.empty() && arr[st.top()] >= arr[i]) {
                st.pop();
            }

            if (!st.empty()) {
                left[i] = st.top();
            }
            st.push(i);
        }

        st = stack<int>();
        for (int i = n-1; i >= 0; i--) {
            while (!st.empty() && arr[st.top()] > arr[i]) {
                st.pop();
            }

            if (!st.empty()) {
                right[i] = st.top();
            }
            st.push(i);
        }

        long long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += static_cast<long long>(i - left[i]) * (right[i] - i) * arr[i] % MOD;
            ans %= MOD;
        }

        return ans;
    }
};
