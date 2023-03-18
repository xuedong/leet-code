class BrowserHistory(homepage: String) {

    private val history: MutableList<String>
    private var current: Int

    init {
        history = mutableListOf(homepage)
        current = 0
    }

    fun visit(url: String) {
        while (history.size > current + 1) {
            history.removeAt(history.size - 1)
        }
        history.add(url)
        current++
    }

    fun back(steps: Int): String {
        current = maxOf(0, current - steps)
        return history[current]
    }

    fun forward(steps: Int): String {
        current = minOf(history.size - 1, current + steps)
        return history[current]
    }

}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * var obj = BrowserHistory(homepage)
 * obj.visit(url)
 * var param_2 = obj.back(steps)
 * var param_3 = obj.forward(steps)
 */