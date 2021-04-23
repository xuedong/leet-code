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
    public TreeNode aux(int[] inorder, int inLeft, int inRight, int[] postorder, int postLeft, int postRight) {
        if (postLeft > postRight) return null;
        
        TreeNode root = new TreeNode(postorder[postRight]);
        for (int i=inLeft; i<=inRight; i++) {
            if (inorder[i] == root.val) {
                root.left = aux(inorder, inLeft, i-1, postorder, postLeft, postLeft+i-1-inLeft);
                root.right = aux(inorder, i+1, inRight, postorder, postLeft+i-inLeft, postRight-1);
                break;
            }
        }
        
        return root;
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int size = inorder.length-1;
        return aux(inorder, 0, size, postorder, 0, size);
    }
}

