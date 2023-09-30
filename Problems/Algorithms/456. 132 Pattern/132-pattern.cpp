#include <stack>
#include <vector>

using namespace std;

class Solution {
public:
    bool find132pattern(vector<int>& nums) {
        stack<int> stack;
        int third = INT_MIN;

        for (int i = nums.size() - 1; i >= 0; i--) {
            if (nums[i] < third) {
                return true;
            }

            while (!stack.empty() && stack.top() < nums[i]) {
                third = stack.top();
                stack.pop();
            }
            stack.push(nums[i]);
        }

        return false;
    }
};
