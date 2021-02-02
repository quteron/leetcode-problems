public boolean isValid(String s) {
    Deque<Character> stack = new ArrayDeque<Character>();

    HashMap<Character, Character> braces = new HashMap<Character, Character>();
    braces.put('(', ')');
    braces.put('{', '}');
    braces.put('[', ']');

    for (char ch : s.toCharArray()) {
        if (braces.containsKey(ch)) {
            stack.addLast(braces.get(ch));
        } else {
            if (stack.isEmpty() || ch != stack.removeLast()) {
                return false;
            }
        }
    }

    return stack.isEmpty();
}
