class CombinationIterator {

    private LinkedList<String> combinations = new LinkedList();
    private int length;

    public CombinationIterator(String s, int length) {
        this.length = length;
        backtracking(s, 0, new StringBuilder());
    }

    public String next() {
        return combinations.removeFirst();
    }

    public boolean hasNext() {
        return !combinations.isEmpty();
    }

    private void backtracking(String s, int pos, StringBuilder current) {
        if (current.length() == length) {
            combinations.addLast(current.toString());
            return;
        }

        for (int i=pos; i<s.length(); i++) {
            current.append(s.charAt(i));
            backtracking(s, i+1, current);
            current.deleteCharAt(current.length()-1);
        }
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
