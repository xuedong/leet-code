/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(cloned);
        
        int targetVal = target.val;
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr.val == targetVal) {
                return curr;
            }
            
            if (curr.left != null) {
                queue.offer(curr.left);
            }
            if (curr.right != null) {
                queue.offer(curr.right);
            }
        }
        
        return null;
    }
}

