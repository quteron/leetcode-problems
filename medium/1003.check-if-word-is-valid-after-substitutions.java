class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque();
        for (char c : s.toCharArray()) {
            if (c == 'c') {
                if (stack.isEmpty() || stack.pop() != 'b') {
                    return false;
                }
                if (stack.isEmpty() || stack.pop() != 'a') {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
