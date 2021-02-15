class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int ans = 0;

        HashMap<String, Integer> map = new HashMap();
        for (int i=0; i<=s.length()-minSize; i++) {
            int r=Math.min(i+maxSize, s.length());
            for (int l=i+minSize; l<=r; l++) {
                String str = s.substring(i, l);
                if (isValid(str, maxLetters)) {
                    int count = map.getOrDefault(str, 0);
                    map.put(str, ++count);
                    ans = Math.max(ans, count);
                }
            }
        }
        return ans;
    }

    private boolean isValid(String s, int maxLetters) {
        Set<Character> visited = new HashSet();
        for (char letter : s.toCharArray()) {
            visited.add(letter);
        }
        return visited.size() <= maxLetters;
    }
}
