public int numSpecialEquivGroups(String[] a) {
    Set<String> groups = new HashSet();
    for (String s : a) {
        int[] code = new int[52];
        for (int i=0; i<s.length(); i++) {
            code[s.charAt(i) - 'a' + 26*(i%2)]++;
        }
        groups.add(Arrays.toString(code));
    }
    return groups.size();
}
