class Solution {
    private String source = "0000";
    
    private void mark(Queue<Pair<String, Integer>> queue, HashSet<String> dead, HashSet<String> visited, StringBuilder sb, int turns) {
        String str = sb.toString();
        if (!dead.contains(str) && !visited.contains(str)) {
            queue.offer(new Pair(str, turns));
            visited.add(str);
        }
    }
    
    public int openLock(String[] deadends, String target) {
        HashSet<String> dead = new HashSet<>();
        HashSet<String> visited = new HashSet<>();
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        
        for (String str : deadends) {
            dead.add(str);
        }
        if (dead.contains(source)) return -1;
        
        queue.offer(new Pair(source, 0));
        visited.add(source);
        
        while (queue.size() > 0) {
            Pair<String, Integer> curr = queue.poll();
            String str = curr.getKey();
            int turns = curr.getValue();
            
            if (str.equals(target)) return turns;
            
            turns++;
            
            for (int i = 0; i < str.length(); i++) {
                StringBuilder sb = new StringBuilder(str);
                char c = str.charAt(i);
                
                if (c == '0') {
					sb.setCharAt(i, '9');
					mark(queue, dead, visited, sb, turns);
					sb.setCharAt(i, '1');
					mark(queue, dead, visited, sb, turns);
				} else if (c == '9') {
					sb.setCharAt(i, '0');
					mark(queue, dead, visited, sb, turns);
					sb.setCharAt(i, '8');
					mark(queue, dead, visited, sb, turns);
				} else {
					c++;
					sb.setCharAt(i, c);
					mark(queue, dead, visited, sb, turns);
					c -= 2;
					sb.setCharAt(i, c);
					mark(queue, dead, visited, sb, turns);
				}
            }
        }
        
        return -1;
    }
}

