impl Solution {
    pub fn num_prime_arrangements(n: i32) -> i32 {
        let num_primes = (2..=n).filter(|&x| (2..x).all(|y| x % y != 0)).count();
        ((1..=num_primes).fold(1, |acc, x| acc * x % 1_000_000_007) * (1..=n as usize - num_primes).fold(1, |acc, x| acc * x % 1_000_000_007) % 1_000_000_007) as i32
    }
}
