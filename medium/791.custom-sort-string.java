public String customSortString(String s, String t) {
    Map<Character, Integer> map = new HashMap();
    for (char ch : t.toCharArray()) {
        int count = map.getOrDefault(ch, 0);
        map.put(ch, ++count);
    }

    StringBuilder ans = new StringBuilder();
    for (char ch : s.toCharArray()) {
        int count = map.getOrDefault(ch, 0);
        for (int i=0; i<count; i++) {
            ans.append(ch);
        }
        map.put(ch, 0);
    }

    for(Character ch : map.keySet()) {
        int count = map.getOrDefault(ch, 0);
        for (int i=0; i<count; i++) {
            ans.append(ch);
        }
    }

    return ans.toString();
}
