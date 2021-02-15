public int maxDepth(String s) {
    int balance = 0;
    int max = 0;

    for (char ch : s.toCharArray()) {
        if (ch == '(') {
            balance++;
        } else if (ch == ')') {
            balance--;
        }

        max = Math.max(max, balance);
    }

    return max;
}
