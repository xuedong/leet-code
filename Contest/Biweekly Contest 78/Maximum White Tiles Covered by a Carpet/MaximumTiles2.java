class Solution {
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        Arrays.sort(tiles, Comparator.comparingInt(tile -> tile[0]));
        int n = tiles.length;
        
        int[] prefixes = new int[n+1];
        for (int i = 0; i < n; i++) {
            prefixes[i+1] = prefixes[i] + tiles[i][1] - tiles[i][0] + 1;
        }
        
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int start = tiles[i][0], end = tiles[i][1];
            int val = start + carpetLen - 1;
            
            if (end > val) {
                return carpetLen;
            }
            
            int endIdx = binary(tiles, i, n-1, val);
            
            int rest = 0;
            if (tiles[endIdx][1] > val) {
                rest = tiles[endIdx][1] - val;
            }
            
            ans = Math.max(ans, prefixes[endIdx+1] - prefixes[i] - rest);
        }
        
        return ans;
    }
    
    private int binary(int[][] tiles, int left, int right, int val) {
        int endIdx = -1;
        
        while (left <= right) {
            int mid = left + (right-left)/2;

            if (tiles[mid][0] <= val && tiles[mid][1] >= val) {
                return mid;
            }
            
            if (tiles[mid][0] > val) {
                right = mid - 1;
            } else {
                endIdx = mid;
                left = mid + 1;
            }
        }

        return endIdx;
    }
}

