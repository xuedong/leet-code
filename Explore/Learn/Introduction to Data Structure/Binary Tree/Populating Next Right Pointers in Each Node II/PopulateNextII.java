/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    private Node findNext(Node node) {
        if (node == null) return null;
        
        Node next = node.next;
        while (next != null) {
            if (next.left != null) return next.left;
            if (next.right != null) return next.right;
            next = next.next;
        }
        
        return null;
    }
    
    private void linkChildren(Node node) {
        if (node == null) return;
        
        if (node.left != null) {
            node.left.next = (node.right != null) ? node.right : findNext(node);
        }
        
        if (node.right != null) {
            node.right.next = findNext(node);
        }
    }
    
    public Node connect(Node root) {
        if (root == null) return null;
        
        Node node = root;
        while (node != null) {
            linkChildren(node);
            node = node.next;
        }
        
        connect(root.left);
        connect(root.right);
        
        return root;
    }
}

