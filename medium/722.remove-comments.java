class Solution {
    public List<String> removeComments(String[] source) {
        List<String> ans = new ArrayList();

        boolean inBlock = false;
        StringBuilder newLine = new StringBuilder();

        for (String line : source) {
            char[] chars = line.toCharArray();
            if (!inBlock) {
                newLine = new StringBuilder();
            }

            for (int i=0; i<chars.length; i++) {
                if (!inBlock && i+1<chars.length && chars[i] == '/' && chars[i+1] == '*') {
                    inBlock = true;
                    i++;
                } else if (inBlock && i+1<chars.length && chars[i] == '*' && chars[i+1] == '/') {
                    inBlock = false;
                    i++;
                } else if (!inBlock && i+1<chars.length && chars[i] == '/' && chars[i+1] == '/') {
                    break;
                } else if (!inBlock) {
                    newLine.append(chars[i]);
                }
            }

            if (!inBlock && newLine.length() != 0) {
                ans.add(newLine.toString());
            }
        }

        return ans;
    }
}
