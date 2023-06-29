class Solution {
    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length, n = grid[0].length();

        Set<Character> keys = new HashSet<>();
        Set<Character> locks = new HashSet<>();
        int allKeys = 0;
        int startRow = -1, startCol = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char cell = grid[i].charAt(j);

                if (cell >= 'a' && cell <= 'f') {
                    allKeys += (1 << (cell - 'a'));
                    keys.add(cell);
                }

                if (cell >= 'A' && cell <= 'F') {
                    locks.add(cell);
                }

                if (cell == '@') {
                    startRow = i;
                    startCol = j;
                }
            }
        }

        Map<Integer, Set<Pair<Integer, Integer>>> visited = new HashMap<>();
        Queue<int[]> queue = new LinkedList<>();
        int[][] neighbors = new int[][] {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        queue.offer(new int[] {startRow, startCol, 0, 0});
        visited.put(0, new HashSet<>());
        visited.get(0).add(new Pair<>(startRow, startCol));

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0], y = curr[1];
            int keyState = curr[2];
            int dist = curr[3];

            for (int[] neighbor : neighbors) {
                int i = x + neighbor[0];
                int j = y + neighbor[1];

                if (i >= 0 && i < m && j >= 0 && j < n && grid[i].charAt(j) != '#') {
                    char cell = grid[i].charAt(j);
                    if (keys.contains(cell)) {
                        if (((1 << (cell - 'a')) & keyState) != 0) {
                            continue;
                        }

                        int newKeyState = (keyState | (1 << (cell - 'a')));
                        if (newKeyState == allKeys) {
                            return dist + 1;
                        }

                        visited.putIfAbsent(newKeyState, new HashSet<>());
                        visited.get(newKeyState).add(new Pair<>(i, j));
                        queue.offer(new int[] {i, j, newKeyState, dist + 1});
                    }

                    if (locks.contains(cell) && ((keyState & (1 << (cell - 'A'))) == 0)) {
                        continue;
                    } else if (!visited.get(keyState).contains(new Pair<>(i, j))) {
                        visited.get(keyState).add(new Pair<>(i, j));
                        queue.offer(new int[] {i, j, keyState, dist + 1});
                    }
                }
            }
        }

        return -1;
    }
}
