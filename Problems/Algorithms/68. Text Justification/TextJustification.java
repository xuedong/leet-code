class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        
        int i = 0;
        while (i < words.length) {
            List<String> curr = getWords(i, words, maxWidth);
            i += curr.size();
            ans.add(createLine(curr, i, words, maxWidth));
        }

        return ans;
    }

    private List<String> getWords(int i, String[] words, int maxWidth) {
        List<String> curr = new ArrayList<>();
        int currWidth = 0;

        while (i < words.length && currWidth + words[i].length() <= maxWidth) {
            curr.add(words[i]);
            currWidth += words[i].length() + 1;
            i++;
        }

        return curr;
    }

    private String createLine(List<String> line, int i, String[] words, int maxWidth) {
        int baseWidth = -1;
        for (String word : line) {
            baseWidth += word.length() + 1;
        }
        
        int extraSpaces = maxWidth - baseWidth;

        if (line.size() == 1 || i == words.length) {
            return String.join(" ", line) + " ".repeat(extraSpaces);
        }

        int count = line.size() - 1;
        int unit = extraSpaces / count;
        int leftover = extraSpaces % count;

        for (int j = 0; j < leftover; j++) {
            line.set(j, line.get(j) + " ");
        }

        for (int j = 0; j < count; j++) {
            line.set(j, line.get(j) + " ".repeat(unit));
        }

        return String.join(" ", line);
    }
}
