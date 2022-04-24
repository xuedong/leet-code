class Solution {
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        val heap = PriorityQueue<IntArray>({ a, b -> b[0] * b[0] + b[1] * b[1] - a[0] * a[0] - a[1] * a[1] })
        
        for (i in 0..points.size-1) {
            if (heap.size < k) {
                heap.add(points[i])
                continue
            }
            
            val point = heap.peek()
            val prevDistance = point[0] * point[0] + point[1] * point[1]
            val currDistance = points[i][0] * points[i][0] + points[i][1] * points[i][1]
            if (currDistance < prevDistance) {
                heap.poll()
                heap.add(points[i])
            }
        }
        
        val results = Array(k) { IntArray(2) }
        for (i in 0..k-1) {
            results[i] = heap.poll()
        }
        
        return results
    }
}

