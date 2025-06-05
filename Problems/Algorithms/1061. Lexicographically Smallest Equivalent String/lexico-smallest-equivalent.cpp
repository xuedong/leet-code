#include <unordered_map>
#include <vector>
#include <string>

using namespace std;

class Solution {
private:
    char dfs(unordered_map<char, vector<char>>& adj, char curr, vector<int>& visited) {
        visited[curr - 'a'] = 1;
        char ch = curr;

        for (char neighbor : adj[curr]) {
            if (visited[neighbor - 'a'] == 0) {
                ch = min(ch, dfs(adj, neighbor, visited));
            }
        }

        return ch;
    }

public:
    string smallestEquivalentString(string s1, string s2, string baseStr) {
        int n = s1.length();
        unordered_map<char, vector<char>> adj;
        for (int i = 0; i < n; i++) {
            char u = s1[i];
            char v = s2[i];
            adj[u].push_back(v);
            adj[v].push_back(u);
        }

        string ans;
        for (char ch : baseStr) {
            vector<int> visited(26, 0);
            char minChar = dfs(adj, ch, visited);
            ans.push_back(minChar);
        }

        return ans;
    }
};
