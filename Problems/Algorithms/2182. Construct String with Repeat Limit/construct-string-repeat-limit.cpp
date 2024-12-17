#include <string>
#include <unordered_map>
#include <queue>

using namespace std;

class Solution {
public:
    string repeatLimitedString(string s, int repeatLimit) {
        unordered_map<char, int> freq;
        for (char ch : s) {
            freq[ch]++;
        }

        priority_queue<char> heap;
        for (auto& [ch, count] : freq) {
            heap.push(ch);
        }

        string ans;
        while (!heap.empty()) {
            char ch = heap.top();
            heap.pop();

            int count = freq[ch];
            int use = min(count, repeatLimit);
            ans.append(use, ch);
            freq[ch] -= use;

            if (freq[ch] > 0 && !heap.empty()) {
                char nextCh = heap.top();
                heap.pop();

                ans.push_back(nextCh);
                freq[nextCh]--;

                if (freq[nextCh] > 0) {
                    heap.push(nextCh);
                }
                heap.push(ch);
            }
        }

        return ans;
    }
};
