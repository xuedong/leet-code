#include <vector>
#include <unordered_map>
#include <string>

using namespace std;

class Solution {
public:
    vector<int> smallestSufficientTeam(vector<string>& req_skills, vector<vector<string>>& people) {
        int n = people.size(), m = req_skills.size();

        unordered_map<string, int> skillId;
        for (int i = 0; i < m; i++) {
            skillId[req_skills[i]] = i;
        }

        vector<int> masks(n);
        for (int i = 0; i < n; i++) {
            for (string skill : people[i]) {
                masks[i] |= 1 << skillId[skill];
            }
        }

        vector<long long> dp(1 << m, (1LL << n) - 1);
        dp[0] = 0;
        for (int mask = 1; mask < (1 << m); mask++) {
            for (int i = 0; i < n; i++) {
                int rest = mask & ~masks[i];
                if (rest != mask) {
                    long long curr = dp[rest] | (1LL << i);
                    if (__builtin_popcountll(curr) < __builtin_popcountll(dp[mask])) {
                        dp[mask] = curr;
                    }
                }
            }
        }

        long long final = dp[(1 << m) - 1];
        vector<int> ans;
        for (int i = 0; i < n; i++) {
            if ((final >> i) & 1) {
                ans.push_back(i);
            }
        }

        return ans;
    }
};
