/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return null;
        
        StringBuilder str = new StringBuilder();
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()){
            TreeNode node = queue.remove();
            
            if (node != null) {
                queue.add(node.left);
                queue.add(node.right);
                str.append(String.valueOf(node.val));
            } else {
                str.append("null");
            }
            
            str.append(",");
        }
        
        str.deleteCharAt(str.length()-1);
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) return null;
        
        String[] strArr = data.split(",");
        if (strArr[0].equals("null")) return null;
        
        int index = 0;
        TreeNode root = new TreeNode(Integer.valueOf(strArr[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            
            int leftIndex = index * 2 + 1;
            int rightIndex = index * 2 + 2;
            
            if (leftIndex < strArr.length) {
                String curr = strArr[leftIndex];
                if (!curr.equals("null")) {
                    TreeNode left = new TreeNode(Integer.parseInt(curr));
                    node.left = left;
                    queue.add(left);
                }
            }
            
            if (rightIndex < strArr.length) {
                String curr = strArr[rightIndex];
                if (!curr.equals("null")) {
                    TreeNode right = new TreeNode(Integer.parseInt(curr));
                    node.right = right;
                    queue.add(right);
                }
            }
            
            index++;
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
