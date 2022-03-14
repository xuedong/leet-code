class Solution {
    fun simplifyPath(path: String): String {
        val stack = ArrayDeque<String>()
        val pathArray = path.split("/")
        
        for (i in 0..pathArray.size-1) {
            if (!stack.isEmpty() && pathArray[i].equals("..")) {
                stack.removeLast()
            } else if (!pathArray[i].equals("") && !pathArray[i].equals(".") && !pathArray[i].equals(".."))  {
                stack.add(pathArray[i])
            }
        }
        
        if (stack.isEmpty()) {
            return "/"
        }
        
        val sb = StringBuilder()
        while (!stack.isEmpty()) {
            sb.insert(0, stack.removeLast())
            sb.insert(0, "/")
        }
        
        return sb.toString()
    }
}

