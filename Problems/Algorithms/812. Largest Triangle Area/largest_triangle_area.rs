impl Solution {
    pub fn largest_triangle_area(points: Vec<Vec<i32>>) -> f64 {
        let mut ans: f64 = 0.0;
        points.iter().enumerate().for_each(|(i, p1)| {
            points[i+1..].iter().enumerate().for_each(|(j, p2)| {
                points[j+1..].iter().enumerate().for_each(|(k, p3)| {
                    let area = 0.5 * ((p1[0] * p2[1] + p2[0] * p3[1] + p3[0] * p1[1]) - (p1[1] * p2[0] + p2[1] * p3[0] + p3[1] * p1[0])).abs() as f64;
                    ans = ans.max(area);
                });
            });
        });
        ans
    }
}
