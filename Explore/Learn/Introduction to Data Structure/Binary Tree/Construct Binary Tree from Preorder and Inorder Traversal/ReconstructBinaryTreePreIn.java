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
    public TreeNode aux(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
        if (preLeft > preRight) return null;
        
        TreeNode root = new TreeNode(preorder[preLeft]);
        for (int i=inLeft; i<=inRight; i++) {
            if (inorder[i] == root.val) {
                root.left = aux(preorder, preLeft+1, preLeft+i-inLeft, inorder, inLeft, i-1);
                root.right = aux(preorder, preLeft+i-inLeft+1, preRight, inorder, i+1, inRight);
                break;
            }
        }
        
        return root;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int size = inorder.length-1;
        return aux(preorder, 0, size, inorder, 0, size);
    }
}

