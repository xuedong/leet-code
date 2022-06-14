impl Solution {
    pub fn is_alien_sorted(words: Vec<String>, order: String) -> bool {
        let order_map = order.as_bytes()
            .iter()
            .enumerate()
            .fold([0; 26], |mut acc, (i, c)| {
                acc[(c-b'a') as usize] = i;
                acc
            });
        
        words.iter()
            .map(|s| {
                s.as_bytes()
                    .iter()
                    .map(|&c| order_map[(c-b'a') as usize])
                    .collect::<Vec<_>>()
            })
            .collect::<Vec<_>>()
            .windows(2)
            .all(|pairs| pairs[0] <= pairs[1])
    }
}

