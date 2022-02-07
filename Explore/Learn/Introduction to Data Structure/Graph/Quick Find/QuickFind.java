// UnionFind.class
class UnionFind {
	private int[] root;

	public UnionFind(int size) {
		root = new int[size];
		for (int i = 0; i < size; i++) {
			root[i] = i;
		}
	}

	public int find(int x) {
		return root[x];
	}

	public void union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);
		if (rootX != rootY) {
			for (int i = 0; i < root.length; i++) {
				if (root[i] == rootY) {
					root[i] = rootX;
				}
			}
		}
	}

	public boolean connected(int x, int y) {
		return find(x) == find(y);
	}
}

// QuickFind.java
// Test case
public class QuickFind {
	public static void main(String[] args) throws Exception {
		UnionFind uf = new UnionFind(10);
		uf.union(1, 2);
		uf.union(2, 5);
		uf.union(5, 6);
		uf.union(6, 7);
		uf.union(3, 8);
		uf.union(8, 9);
		System.out.println(uf.connected(1, 5)); // should be true
		System.out.println(uf.connected(5, 7)); // should be true
		System.out.println(uf.connected(4, 9)); // should be false
		uf.union(9, 4);
		System.out.println(uf.connected(4, 9)); // should be true now
	}
}

