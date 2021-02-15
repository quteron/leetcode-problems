class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String pattern = "123456789";

        int loLen = String.valueOf(low).length();
        int hiLen = String.valueOf(high).length();

        List<Integer> ans = new ArrayList();
        for (int len=loLen; len<=hiLen; len++) {
            for (int l=0; l+len<=pattern.length(); l++) {
                int number = Integer.parseInt(pattern.substring(l, l+len));
                if (low <= number && number <= high) {
                    ans.add(number);
                }

                if (number > high) {
                    break;
                }
            }
        }

        return ans;
    }
}
