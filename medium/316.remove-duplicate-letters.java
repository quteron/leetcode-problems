public String removeDuplicateLetters(String s) {
    char[] chars = s.toCharArray();

    Set<Character> seen = new HashSet();

    Map<Character, Integer> map = new HashMap();
    for (int i=0; i<chars.length; i++) {
        map.put(chars[i], i);
    }

    Deque<Character> stack = new ArrayDeque();
    for (int i=0; i<chars.length; i++) {
        if (seen.contains(chars[i])) {
            continue;
        }

        while (!stack.isEmpty()) {
            char prev = stack.peekLast();
            if (prev > chars[i] && map.get(prev) > i) {
                seen.remove(prev);
                stack.removeLast();
            } else {
                break;
            }
        }

        seen.add(chars[i]);
        stack.addLast(chars[i]);
    }

    StringBuilder ans = new StringBuilder();
    for (char c : stack) {
        ans.append(c);
    }
    return ans.toString();
}
