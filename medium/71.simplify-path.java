class Solution {
    public String simplifyPath(String path) {
        Deque<String> queue = new ArrayDeque();
        StringBuilder curr = new StringBuilder();

        for (int i=0; i<=path.length(); i++) {
            if (i == path.length() || path.charAt(i) == '/') {
                if (curr.length() > 0) {
                    String p = curr.toString();
                    curr.setLength(0);

                    if (p.equals("..") && !queue.isEmpty()) {
                        queue.removeLast();
                    } else if (!p.equals("..") && !p.equals(".")) {
                        queue.addLast(p);
                    }
                }
            } else if (i != path.length()) {
                curr.append(path.charAt(i));
            }
        }

        StringBuilder ans = new StringBuilder();
        for (String p : queue) {
            ans.append("/").append(p);
        }

        return ans.length()  >0 ? ans.toString() : "/";
    }
}
