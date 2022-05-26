class Solution {
public:
    int findPairs(vector<int>& nums, int k) {
        int n = nums.size();

        map<int, int> pairs;
        for (int num : nums) {
            pairs[num]++;
        }

        int ans = 0;
        for (auto pair : pairs) {
            if (k == 0) {
                if (pair.second > 1) {
                    ans++;
                }
            } else if (pairs.count(pair.first+k)) {
                ans++;
            }
        }

        return ans;
    }
};

