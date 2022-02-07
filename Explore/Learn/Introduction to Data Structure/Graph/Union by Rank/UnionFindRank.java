// UnionFind.class
class UnionFind {
	private int[] parent;
	private int[] rank;

	public UnionFind(int size) {
		parent = new int[size];
		rank = new int[size];
		for (int i = 0; i < size; i++) {
			parent[i] = i;
			rank[i] = 1;
		}
	}

	public int find(int x) {
		while (x != parent[x]) {
			x = parent[x];
		}
		return x;
	}

	public void union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);

		if (rootX != rootY) {
			if (rank[rootX] > rank[rootY]) {
				parent[rootY] = rootX;
			} else if (rank[rootX] < rank[rootY]) {
				parent[rootX] = rootY;
			} else {
				parent[rootY] = rootX;
				rootX += 1;
			}
		}
	}

	public boolean connected(int x, int y) {
		return find(x) == find(y);
	}
}

// UnionFindRank.java
// Test case
public class UnionFindRank {
    public static void main(String[] args) throws Exception {
        UnionFind uf = new UnionFind(10);
        uf.union(1, 2);
        uf.union(2, 5);
        uf.union(5, 6);
        uf.union(6, 7);
        uf.union(3, 8);
        uf.union(8, 9);
        System.out.println(uf.connected(1, 5)); // true
        System.out.println(uf.connected(5, 7)); // true
        System.out.println(uf.connected(4, 9)); // false
        uf.union(9, 4);
        System.out.println(uf.connected(4, 9)); // true
    }
}

