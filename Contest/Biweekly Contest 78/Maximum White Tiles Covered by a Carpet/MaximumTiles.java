class Solution {
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        Arrays.sort(tiles, Comparator.comparingInt(tile -> tile[0]));
        int n = tiles.length;
        
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int curr = 0;
            int rest = carpetLen;
            
            int j = i;
            while (rest > 0 && j < n) {
                curr += Math.min(tiles[j][1]-tiles[j][0]+1, rest);
                if (j == n-1) break;
                rest -= tiles[j+1][0] - tiles[j][0];
                j++;
            }
            
            ans = Math.max(ans, curr);
        }
        
        return ans;
    }
}

