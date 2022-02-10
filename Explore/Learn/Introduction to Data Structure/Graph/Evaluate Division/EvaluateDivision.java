class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        UnionFind uf = new UnionFind();
        for (int i = 0; i < equations.size(); i++) {
            uf.union(equations.get(i).get(0), equations.get(i).get(1), values[i]);
        }
        
        int n = queries.size();
        double[] results = new double[n];
        for (int i = 0; i < n; i++) {
            Node root1 = uf.find(queries.get(i).get(0));
            Node root2 = uf.find(queries.get(i).get(1));
            if (root1 == null || root2 == null || !root1.root.equals(root2.root)) {
                results[i] = -1.0;
            } else {
                results[i] = root1.ratio / root2.ratio;
            }
        }
        
        return results;
    }
    
    class Node {
        public String root;
        public double ratio;
        public Node(String root, double ratio) {
            this.root = root;
            this.ratio = ratio;
        }
    }
    
    class UnionFind {
        private Map<String, Node> roots = new HashMap<>();
        
        public Node find(String s) {
            if (!roots.containsKey(s)) return null;
            
            Node node = roots.get(s);
            if (node.root.equals(s)) {
                return node;
            }
            Node root = find(node.root);
            node.root = root.root;
            node.ratio *= root.ratio;
            return node;
        }
        
        public void union(String s1, String s2, double ratio) {
            boolean containsS1 = roots.containsKey(s1);
            boolean containsS2 = roots.containsKey(s2);
            
            if (!containsS1 && !containsS2) {
                roots.put(s1, new Node(s2, ratio));
                roots.put(s2, new Node(s2, 1.0));
            } else if (!containsS1) {
                roots.put(s1, new Node(s2, ratio));
            } else if (!containsS2) {
                roots.put(s2, new Node(s1, 1.0 / ratio));
            } else {
                Node root1 = find(s1);
                Node root2 = find(s2);
                roots.put(root1.root, new Node(root2.root, ratio * root2.ratio / root1.ratio));
            }
        }
    }
}

