#include <string>

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
    string output;

    void preOrder(TreeNode* node) {
        if (!node) return;

        output += to_string(node->val);
        if (node->left) {
            output.push_back('(');
            preOrder(node->left);
            output.push_back(')');
        }
        if (node->right) {
            if (!node->left) {
                output += "()";
            }

            output.push_back('(');
            preOrder(node->right);
            output.push_back(')');
        }
    }

    string tree2str(TreeNode* root) {
        preOrder(root);
        return output;
    }
};
