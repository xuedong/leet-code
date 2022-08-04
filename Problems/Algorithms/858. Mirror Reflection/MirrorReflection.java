class Solution {
    public int gcd(int a, int b) {
        if (b != 0) {
            return gcd(b, Math.abs(b-a));
        }
        return a;
    }
    
    public int mirrorReflection(int p, int q) {
        int d = gcd(p, q);
        p /= d;
        q /= d;
        
        if (p % 2 == 0) {
            return 2;
        } else if (q % 2 == 1) {
            return 1;
        } else {
            return 0;
        }
    }
}

