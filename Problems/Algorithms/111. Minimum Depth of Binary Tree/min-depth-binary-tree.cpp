#include<queue>

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
    int minDepth(TreeNode* root) {
        if (!root) {
            return 0;
        }

        queue<TreeNode*> queue;
        queue.push(root);
        int depth = 1;

        while (!queue.empty()) {
            int size = queue.size();

            while (size--) {
                TreeNode* node = queue.front();
                queue.pop();

                if (!node) {
                    continue;
                }

                if (!node->left && !node->right) {
                    return depth;
                }

                queue.push({node->left});
                queue.push({node->right});
            }

            depth++;
        }

        return -1;
    }
};
