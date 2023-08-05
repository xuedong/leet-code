#include <vector>

using namespace std;

// Definition for a binary tree node.
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};
 
class Solution {
public:
    vector<TreeNode*> allTrees(int start, int end, map<pair<int, int>, vector<TreeNode*>>& dp) {
        vector<TreeNode*> result;

        if (start > end) {
            result.push_back(nullptr);
            return result;
        }

        if (dp.find(make_pair(start, end)) != dp.end()) {
            return dp[make_pair(start, end)];
        }

        for (int i = start; i <= end; i++) {
            vector<TreeNode*> leftTrees = allTrees(start, i-1, dp);
            vector<TreeNode*> rightTrees = allTrees(i+1, end, dp);

            for (auto left : leftTrees) {
                for (auto right : rightTrees) {
                    TreeNode* root = new TreeNode(i, left, right);
                    result.push_back(root);
                }
            }
        }

        return dp[make_pair(start, end)] = result;
    }

    vector<TreeNode*> generateTrees(int n) {
        map<pair<int, int>, vector<TreeNode*>> dp;
        return allTrees(1, n, dp);
    }
};
