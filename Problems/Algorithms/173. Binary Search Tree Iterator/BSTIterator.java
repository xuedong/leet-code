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
class BSTIterator {
    private Queue<Integer> queue;

    public BSTIterator(TreeNode root) {
        queue = new LinkedList<>();
        this.inorder(root);
    }
    
    public int next() {
        return this.queue.poll();
    }
    
    public boolean hasNext() {
        return !this.queue.isEmpty();
    }
    
    private void inorder(TreeNode node) {
        if (node == null) return;
        
        inorder(node.left);
        queue.add(node.val);
        inorder(node.right);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
