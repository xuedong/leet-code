class Solution {
    private long prod(int n) {
        long ans = 1;
        for (int i = 0; i < n; i++) {
            ans = (2*n-i) * ans / (i+1);
        }
        return ans;
    }
    
    public int numTrees(int n) {
        return (int) (prod(n) / (n+1));
    }
}

