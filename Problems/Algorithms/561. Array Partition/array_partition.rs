impl Solution {
    pub fn array_pair_sum(mut nums: Vec<i32>) -> i32 {
        nums.sort();
        nums.chunks(2).map(|x| x[0]).sum()
    }
}
