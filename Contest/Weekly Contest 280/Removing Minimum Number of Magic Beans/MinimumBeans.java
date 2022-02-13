class Solution {
    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        int len = beans.length;
        
        long maxRectangle = 0;
        long total = 0;
        for (int i = 0; i < len; i++) {
            total += beans[i];
            maxRectangle = Math.max(maxRectangle, (long) beans[i] * (len-i));
        }
        
        return total - maxRectangle;
    }
}

