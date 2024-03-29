struct ParkingSystem {
    big: i32,
    medium: i32,
    small: i32,
}


/** 
 * `&self` means the method takes an immutable reference.
 * If you need a mutable reference, change it to `&mut self` instead.
 */
impl ParkingSystem {

    fn new(big: i32, medium: i32, small: i32) -> Self {
        let (mut big, mut medium, mut small) = (big, medium, small);
        Self {
            big,
            medium,
            small
        }
    }
    
    fn add_car(&mut self, car_type: i32) -> bool {
        match car_type {
            1 => {
                if self.big == 0 {
                    false
                } else {
                    self.big -= 1;
                    true
                }
            }
            2 => {
                if self.medium == 0 {
                    false
                } else {
                    self.medium -= 1;
                    true
                }
            }
            3 => {
                if self.small == 0 {
                    false
                } else {
                    self.small -= 1;
                    true
                }
            }
            _ => false
        }
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * let obj = ParkingSystem::new(big, medium, small);
 * let ret_1: bool = obj.add_car(carType);
 */
