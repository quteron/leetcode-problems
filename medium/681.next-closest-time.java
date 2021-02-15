class Solution {
    public String nextClosestTime(String time) {
        int start = 60 * Integer.parseInt(time.substring(0, 2));
        start += Integer.parseInt(time.substring(3));

        int lo = start;
        int hi = -1;

        Set<Integer> digits = new HashSet();
        for (char digit : time.toCharArray()) {
            if (digit != ':') {
                digits.add(digit - '0');
            }
        }

        for (int h1 : digits) {
            for (int h2 : digits) {
                if (h1*10+h2 >= 24) {
                    continue;
                }

                for (int m1 : digits) {
                    for (int m2 : digits) {
                        if (m1*10+m2 >= 60) {
                            continue;
                        }

                        // in minutes
                        int current = 60 * (h1*10+h2) + m1*10+m2;
                        if (current == start) {
                            continue;
                        } else if (start > current && (lo == -1 || lo > current)) {
                            lo = current;
                        } else if (start < current && (hi == -1 || hi > current)) {
                            hi = current;a
                        }
                    }
                }
            }
        }

        int ans = hi == -1 ? lo : hi;
        return String.format("%02d:%02d", ans / 60, ans % 60);
    }
}
