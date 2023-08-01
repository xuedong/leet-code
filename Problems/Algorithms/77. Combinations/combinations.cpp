#include <vector>

using namespace std;

class Solution {
public:
    vector<vector<int>> ans;
    vector<int> curr;

    void helper(int i, int n, int k, vector<int>& curr) {
        if (k == 0) {
            ans.push_back(curr);
            return;
        }

        if (i == n) {
            return;
        }

        helper(i+1, n, k, curr);
        curr.push_back(i+1);
        helper(i+1, n, k-1, curr);
        curr.pop_back();
    }

    vector<vector<int>> combine(int n, int k) {
        helper(0, n, k, curr);
        return ans;
    }
};
