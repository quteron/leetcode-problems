public List<List<String>> groupStrings(String[] strings) {
    Map<String, List<String>> map = new HashMap();
    for (String str : strings) {
        String code = getCode(str);
        map.putIfAbsent(code, new ArrayList());
        map.get(code).add(str);
    }

    List<List<String>> ans = new ArrayList();
    for (List<String> group : map.values()) {
        ans.add(group);
    }

    return ans;
}

private String getCode(String s) {
    StringBuilder ans = new StringBuilder();

    for (int i=1; i<s.length(); i++) {
        int code = (s.charAt(i-1) - s.charAt(i) + 26) % 26;
        ans.append(code).append("#");
    }
    return ans.toString();
}
