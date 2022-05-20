/** 
 * The API guess is defined in the parent class.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * fun guess(num: Int): Int {}
 */

class Solution: GuessGame() {
    override fun guessNumber(n: Int): Int {
        var left = 1
        var right = n
        
        while (left <= right) {
            var mid = left + (right - left) / 2
            
            val curr = guess(mid)
            if (curr == 0) {
                return mid
            } else if (curr == -1) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        
        return -1
    }
}

