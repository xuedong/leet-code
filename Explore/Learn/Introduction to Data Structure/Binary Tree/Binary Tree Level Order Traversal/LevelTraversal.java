/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        
        if (root != null) {
            queue.add(root);
        }
        
        while (queue.size() > 0) {
            int levelSize = queue.size();
            List<Integer> curr = new ArrayList<>();
            
            for (int i=1; i<=levelSize; i++) {
                TreeNode node = queue.remove();
                curr.add(node.val);
                
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            
            output.add(curr);
        }
        
        return output;
    }
}

