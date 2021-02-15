class Solution {
    public int maxLength(List<String> arr) {
        int max = 0;
        for (int i=0; i<arr.size(); i++) {
            max = Math.max(max, backtracking(arr, i, 0, new HashSet()));
        }
        return max;
    }

    private int backtracking(List<String> arr, int pos, int len, Set<Character> chars) {
        if (pos == arr.size()) {
            return len;
        }

        int max = 0;
        for (int i=pos; i<arr.size(); i++) {
            String part = arr.get(i);
            Set<Character> newChars = toSet(part);
            if (part.length() != newChars.size()) {
                continue;
            }

            if (!hasUniqueChars(chars, newChars)) {
                continue;
            }

            chars.addAll(newChars);
            max = Math.max(max, backtracking(arr, i+1, len + part.length(), chars));
            chars.removeAll(newChars);
        }

        return Math.max(len, max);
    }

    private boolean hasUniqueChars(Set<Character> a, Set<Character> b) {
        for (Character ch : a) {
            if (b.contains(ch)) {
                return false;
            }
        }

        return true;
    }

    private Set<Character> toSet(String part) {
        Set<Character> set = new HashSet();
        for (char ch : part.toCharArray()) {
            set.add(ch);
        }
        return set;
    }
}
