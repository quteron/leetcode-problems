class Solution {
    public List<Integer> countSteppingNumbers(int low, int high) {
        List<Integer> ans = new ArrayList();
        if (low == 0) {
            ans.add(0);
        }

        Deque<Integer> queue = new LinkedList();
        for (int i=1; i<10; i++) {
            queue.addLast(i);
        }

        while (!queue.isEmpty()) {
            int number = queue.pollFirst();
            if (number >= low && high >= number) {
                ans.add(number);
            }

            if (number > high / 10) {
                continue;
            }

            int lastDigit = number % 10;
            if (lastDigit > 0) {
                queue.add(number*10+lastDigit-1);
            }
            if (lastDigit < 9) {
                queue.add(number*10+lastDigit+1);
            }
        }

        return ans;
    }
}
