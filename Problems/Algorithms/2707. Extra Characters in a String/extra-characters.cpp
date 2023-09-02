#include <unordered_map>
#include <vector>
#include <string>

using namespace std;

class TrieNode {
public:
    unordered_map<char, TrieNode*> children;
    bool is_word;
};

class Solution {
public:
    TrieNode* build(vector<string>& dictionary) {
        auto root = new TrieNode();

        for (auto& word : dictionary) {
            auto node = root;
            for (auto& ch : word) {
                if (node->children.find(ch) == node->children.end()) {
                    node->children[ch] = new TrieNode();
                }
                node = node->children[ch];
            }
            node->is_word = true;
        }

        return root;
    }

    int minExtraChar(string s, vector<string>& dictionary) {
        int n = s.length();
        auto root = build(dictionary);
        
        unordered_map<int, int> dp;
        function<int(int)> helper = [&](int start) {
            if (start == n) {
                return 0;
            }
            if (dp.count(start)) {
                return dp[start];
            }

            int ans = helper(start+1) + 1;
            TrieNode* node = root;
            for (int end = start; end < n; end++) {
                char ch = s[end];
                if (node->children.find(ch) == node->children.end()) {
                    break;
                }

                node = node->children[ch];
                if (node->is_word) {
                    ans = min(ans, helper(end+1));
                }
            }

            return dp[start] = ans;
        };

        return helper(0);
    }
};
