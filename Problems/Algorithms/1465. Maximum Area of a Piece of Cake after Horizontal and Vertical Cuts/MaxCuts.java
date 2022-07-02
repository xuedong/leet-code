class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int MOD = 1000000007;
        
        Arrays.sort(horizontalCuts);
        
        int maxH = horizontalCuts[0];
        for (int i = 1; i < horizontalCuts.length; i++) {
            maxH = Math.max(maxH, horizontalCuts[i]-horizontalCuts[i-1]);
        }
        maxH = Math.max(maxH, h-horizontalCuts[horizontalCuts.length-1]);
        
        Arrays.sort(verticalCuts);
        
        int maxW = verticalCuts[0];
        for (int j = 1; j < verticalCuts.length; j++) {
            maxW = Math.max(maxW, verticalCuts[j]-verticalCuts[j-1]);
        }
        maxW = Math.max(maxW, w-verticalCuts[verticalCuts.length-1]);
        
        return (int) ((Long.valueOf(maxH) * Long.valueOf(maxW)) % MOD);
    }
}

