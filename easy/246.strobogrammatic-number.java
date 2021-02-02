public boolean isStrobogrammatic(String num) {
    HashMap<Character, Character> map = new HashMap<Character, Character>();
    map.put('0', '0');
    map.put('1', '1');
    map.put('6', '9');
    map.put('8', '8');
    map.put('9', '6');

    int l = 0, r = num.length()-1;
    while (l <= r) {
        char left = num.charAt(l++);
        char right = num.charAt(r--);

        if (!map.containsKey(left)) {
            return false;
        }

        if (map.get(left) != right) {
            return false;
        }
    }

    return true;
}
