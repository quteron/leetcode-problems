class Solution {
    public int maxUniqueSplit(String s) {
        return maxUniqueSplit(s, 0, new HashSet());
    }

    private int maxUniqueSplit(String s, int pos, Set<String> current) {
        if (pos == s.length()) {
            return current.size();
        }

        int max = 0;
        for (int i=pos; i<s.length(); i++) {
            String subStr = s.substring(pos, i+1);
            if (current.contains(subStr)) {
                continue;
            }

            current.add(subStr);
            max = Math.max(max, maxUniqueSplit(s, i+1, current));
            current.remove(subStr);
        }

        return max;
    }
}
