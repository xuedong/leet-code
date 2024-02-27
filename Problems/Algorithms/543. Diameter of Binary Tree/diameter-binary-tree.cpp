#include <algorithm>

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
private:
    int helper(TreeNode* node, int& diameter) {
        if (!node) {
            return 0;
        }

        int left = helper(node->left, diameter);
        int right = helper(node->right, diameter);

        diameter = max(diameter, left + right);
        return max(left, right) + 1;
    }

public:
    int diameterOfBinaryTree(TreeNode* root) {
        int ans = 0;
        helper(root, ans);
        return ans;
    }
};
