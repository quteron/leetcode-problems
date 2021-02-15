class Solution {
    public List<String> generatePalindromes(String s) {
        Map<Character, Integer> map = new HashMap();
        if (!canPermutePalindrome(s, map)) {
            return new ArrayList();
        }

        char[] arr = new char[s.length()/2];
        char odd = buildPalindromeHalf(map, arr);

        Set<String> ans = new HashSet();
        generatePalindromes(arr, 0, odd, ans);
        return new ArrayList(ans);
    }

    private boolean canPermutePalindrome(String s, Map<Character, Integer> map) {
        int odd = 0;

        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);

            int count = map.getOrDefault(ch, 0);
            map.put(ch, ++count);

            if (count % 2 == 0) {
                odd--;
            } else {
                odd++;
            }
        }

        return odd <= 1;
    }

    private char buildPalindromeHalf(Map<Character, Integer> map, char[] arr) {
        char odd = 0;
        int k = 0;

        for(Character key : map.keySet()) {
            int count = map.get(key);
            if (count % 2 == 1) {
                odd = key;
            }

            count /= 2;
            while (count > 0) {
                arr[k++] = key;
                count--;
            }
        }

        return odd;
    }

    private void generatePalindromes(char[] arr, int pos, char odd, Set<String> ans) {
        if (pos == arr.length) {
            ans.add(buildPalindrome(arr, odd));
            return;
        }

        for (int i=pos; i<arr.length; i++) {
            if ((i > pos && arr[pos] == arr[i])) {
                continue;
            }

            swap(arr, pos, i);
            generatePalindromes(arr, pos+1, odd, ans);
            swap(arr, i, pos);
        }
    }

    private String buildPalindrome(char[] arr, char odd) {
        int n = arr.length*2 + (odd != 0 ? 1 : 0);
        char[] palindrome = new char[n];

        int k=0;
        for (char ch : arr) {
            palindrome[k++] = ch;
            palindrome[n-k] = ch;
        }

        if (odd > 0) {
            palindrome[k] = odd;
        }

        return new String(palindrome);
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
