#include <vector>
#include <stack>
#include <string>

using namespace std;

class Solution {
public:
    vector<int> survivedRobotsHealths(vector<int>& positions, vector<int>& healths, string directions) {
        int n = positions.size();
        
        vector<int> indices(n);
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        sort(indices.begin(), indices.end(), [&](int a, int b) {
            return positions[a] < positions[b];
        });

        stack<int> stack;
        vector<int> result;
        for (int i : indices) {
            if (directions[i] == 'R') {
                stack.push(i);
            } else {
                while (!stack.empty() && healths[i] > 0) {
                    int j = stack.top();
                    stack.pop();

                    if (healths[j] > healths[i]) {
                        healths[j] -= 1;
                        healths[i] = 0;
                        stack.push(j);
                    } else if (healths[j] < healths[i]) {
                        healths[i] -= 1;
                        healths[j] = 0;
                    } else {
                        healths[i] = 0;
                        healths[j] = 0;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (healths[i] > 0) {
                result.push_back(healths[i]);
            }
        }

        return result;
    }
};
