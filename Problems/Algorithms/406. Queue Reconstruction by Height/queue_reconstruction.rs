impl Solution {
    pub fn reconstruct_queue(mut people: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        people.sort_by_key(|p| (-p[0], p[1]));
        
        let mut results: Vec<Vec<i32>> = Vec::new();
        for p in people.iter() {
            results.insert(p[1] as usize, p.to_vec());
        }
        results
    }
}

