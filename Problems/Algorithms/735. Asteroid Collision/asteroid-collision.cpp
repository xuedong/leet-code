#include <vector>
#include <stack>

using namespace std;

class Solution {
public:
    vector<int> asteroidCollision(vector<int>& asteroids) {
        stack<int> stack;

        for (int asteroid : asteroids) {
            int flag = 1;
            while (!stack.empty() && (stack.top() > 0 && asteroid < 0)) {
                if (abs(stack.top()) < abs(asteroid)) {
                    stack.pop();
                    continue;
                } else if (abs(stack.top()) == abs(asteroid)) {
                    stack.pop();
                }

                flag = 0;
                break;
            }

            if (flag) {
                stack.push(asteroid);
            }
        }

        vector<int> results(stack.size());
        for (int i = results.size() - 1; i >= 0; i--) {
            results[i] = stack.top();
            stack.pop();
        }

        return results;
    }
};
