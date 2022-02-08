class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int numberOfVertices = s.length();
        char[] res = new char[numberOfVertices];
        
        UnionFind uf = new UnionFind(numberOfVertices);
        for (List<Integer> pair : pairs) {
            uf.union(pair.get(0), pair.get(1));
        }
        
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < numberOfVertices; i++) {
            int key = uf.find(i);
            List<Integer> cc;
            if (map.containsKey(key)) {
                cc = map.get(key);
            } else {
                cc = new ArrayList<Integer>();
            }
            cc.add(i);
            map.put(key, cc);
        }
        
        for (int key : map.keySet()) {
            List<Integer> componentIndices = map.get(key);
            char[] componentChars = new char[componentIndices.size()];
            
            int i = 0;
            for (int j : componentIndices) {
                componentChars[i] = s.charAt(j);
                i += 1;
            }
            Arrays.sort(componentChars);
            
            i = 0;
            for (int j : componentIndices) {
                res[j] = componentChars[i];
                i += 1;
            }
        }
        
        return String.valueOf(res);
    }
    
    class UnionFind {
        private int[] root;
        private int[] rank;
        
        UnionFind(int numberOfVertices) {
            root = new int[numberOfVertices];
            rank = new int[numberOfVertices];
            
            for (int i = 0; i < numberOfVertices; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }
        
        int find(int x) {
            if (x == root[x]) {
                return x;
            }
            return root[x] = find(root[x]);
        }
        
        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    root[rootX] = rootY;
                } else {
                    root[rootY] = rootX;
                    rank[rootX] += 1;
                }
            }
        }
    }
}

