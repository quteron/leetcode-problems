class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap();
        for (String path : paths) {
            String[] parts = path.split(" ");
            String root = parts[0];

            for (int i=1; i<parts.length; i++) {
                int j=0;

                StringBuilder name = new StringBuilder();
                name.append(root).append("/");
                while (j<parts[i].length() && parts[i].charAt(j) != '(') {
                    name.append(parts[i].charAt(j++));
                }

                j++;

                StringBuilder content = new StringBuilder();
                while (j<parts[i].length() && parts[i].charAt(j) != ')') {
                    content.append(parts[i].charAt(j++));
                }

                String key = content.toString();
                map.putIfAbsent(key, new ArrayList());
                map.get(key).add(name.toString());
            }
        }

        List<List<String>> ans = new ArrayList();
        for (String key : map.keySet()) {
            List<String> group = map.get(key);
            if (group.size() > 1) {
                ans.add(map.get(key));
            }
        }

        return ans;
    }
}
