class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String path : paths) {
            String[] strings = path.split(" ");
            String dir = strings[0];
            for (int i = 1; i < strings.length; i++) {
                String[] file = strings[i].split("\\(");
                String name = file[0];
                String content = file[1].substring(0, file[1].length() - 1);
                if (!map.containsKey(content)) {
                    map.put(content, new ArrayList<>());
                }
                map.get(content).add(dir + "/" + name);
            }
        }

        List<List<String>> result = new ArrayList<>();
        for (String key : map.keySet()) {
            if (map.get(key).size() > 1) {
                result.add(map.get(key));
            }
        }
        return result;
    }
}
