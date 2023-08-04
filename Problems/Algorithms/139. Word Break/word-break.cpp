#include <string>
#include <vector>
#include <queue>
#include <unordered_set>

using namespace std;

class Solution {
public:
    bool wordBreak(string s, vector<string>& wordDict) {
        int n = s.length();

        unordered_set<string> words(wordDict.begin(), wordDict.end());
        vector<bool> visited(n, false);

        queue<int> queue;
        queue.push(0);

        while (!queue.empty()) {
            int start = queue.front();
            queue.pop();

            if (start == n) {
                return true;
            }

            for (int end = start + 1; end <= n; end++) {
                if (visited[end]) {
                    continue;
                }

                if (words.find(s.substr(start, end - start)) != words.end()) {
                    queue.push(end);
                    visited[end] = true;
                }
            }
        }

        return false;
    }
};
