class TrieNode {
    TrieNode[] children;
    String word;

    public TrieNode() {
        children = new TrieNode[26];
        word = null;
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.word = word;
    }
}

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length;
        int n = board[0].length;

        List<String> result = new ArrayList<>();
        if (board == null || n == 0 || m == 0) {
            return result;
        }
        if (words == null || words.length == 0) {
            return result;
        }

        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, visited, i, j, trie.root, result);
            }
        }
        return result;
    }

    private void dfs(char[][] board, boolean[][] visited, int i, int j, TrieNode node, List<String> result) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) {
            return;
        }
        char c = board[i][j];
        if (node.children[c - 'a'] == null) {
            return;
        }
        node = node.children[c - 'a'];
        if (node.word != null) {
            result.add(node.word);
            node.word = null;
        }
        visited[i][j] = true;
        dfs(board, visited, i + 1, j, node, result);
        dfs(board, visited, i - 1, j, node, result);
        dfs(board, visited, i, j + 1, node, result);
        dfs(board, visited, i, j - 1, node, result);
        visited[i][j] = false;
    }
}
