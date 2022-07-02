const MOD: i64 = 1_000_000_007;

impl Solution {
    pub fn max_area(h: i32, w: i32, horizontal_cuts: Vec<i32>, vertical_cuts: Vec<i32>) -> i32 {
        let mut hc = horizontal_cuts;
        let mut vc = vertical_cuts;
        
        hc.extend(&[0, h]);
        vc.extend(&[0, w]);
        
        hc.sort_unstable();
        vc.sort_unstable();
        
        let maxh = hc.windows(2).map(|x| x[1]-x[0]).max().unwrap() as i64;
        let maxv = vc.windows(2).map(|x| x[1]-x[0]).max().unwrap() as i64;
        
        ((maxh * maxv) % MOD) as i32
    }
}

