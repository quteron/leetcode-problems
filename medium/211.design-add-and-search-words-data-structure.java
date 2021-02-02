class WordDictionary {

    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean word = false;
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for (char letter : word.toCharArray()) {
            node.children.putIfAbsent(letter, new TrieNode());
            node = node.children.get(letter);
        }
        node.word = true;
    }

    public boolean search(String word) {
        return search(word, 0, root);
    }

    private boolean search(String word, int index, TrieNode node) {
        while (index != word.length()) {
            char letter = word.charAt(index);
            if (!node.children.containsKey(letter)) {
                if (letter == '.') {
                    for (TrieNode child : node.children.values()) {
                        if (search(word, index+1, child)) {
                            return true;
                        }
                    }
                }
                return false;
            } else {
                node = node.children.get(letter);
                index++;
            }
        }

        return node.word;
    }
}
