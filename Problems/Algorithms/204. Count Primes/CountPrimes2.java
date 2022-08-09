/* Opimized Sieve of Eratosthenes */
class Solution {
    public int countPrimes(int n) {
        boolean[] primes = new boolean[n];
        Arrays.fill(primes, true);
        
        for (int i = 2; i * i < n; i++) {
            if (!primes[i]) continue;
            
            for (int j = i * i; j < n; j += i) {
                primes[j] = false;
            }
        }
        
        int ans = 0;
        for (int i = 2; i < n; i++) {
            if (primes[i]) ans++;
        }
        return ans;
    }
}

