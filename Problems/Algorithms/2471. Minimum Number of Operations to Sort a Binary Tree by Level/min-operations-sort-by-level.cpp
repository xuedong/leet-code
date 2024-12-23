#include <queue>
#include <vector>
#include <unordered_map>

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
    int minimumOperations(TreeNode* root) {
        queue<TreeNode*> queue;
        queue.push(root);
        
        int ans = 0;
        while (!queue.empty()) {
            int size = queue.size();
            vector<int> values(size);

            for (int i = 0; i < size; i++) {
                TreeNode* node = queue.front();
                queue.pop();

                values[i] = node->val;
                if (node->left != nullptr) queue.push(node->left);
                if (node->right != nullptr) queue.push(node->right);
            }

            ans += getMinSwaps(values);
        }

        return ans;
    }

private:
    int getMinSwaps(vector<int>& original) {        
        vector<int> target = original;
        sort(target.begin(), target.end());

        int swaps = 0;
        int n = original.size();

        unordered_map<int, int> pos;
        for (int i = 0; i < n; i++) {
            pos[original[i]] = i;
        }

        for (int i = 0; i < n; i++) {
            if (original[i] != target[i]) {
                swaps++;

                int curr = pos[target[i]];
                pos[original[i]] = curr;
                swap(original[curr], original[i]);
            }
        }

        return swaps;
    }
};
