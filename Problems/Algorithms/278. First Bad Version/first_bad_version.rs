// The API isBadVersion is defined for you.
// isBadVersion(version:i32)-> bool;
// to call it use self.isBadVersion(version)
impl Solution {
    pub fn first_bad_version(&self, n: i32) -> i32 {
		let (mut left, mut right) = (0, n);
        
        while left < right {
            let mid = left + (right - left) / 2;
            
            match self.isBadVersion(mid) {
                true => right = mid,
                false => left = mid + 1,
            }
        }
        
        right
    }
}

