class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        // added empty rows
        List<StringBuilder> rows = new ArrayList();
        for(int i=0; i<Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }

        // put character on the row
        int curRow = 1;
        boolean goDown = false;
        for (char c : s.toCharArray()) {
            rows.get(curRow-1).append(c);

            if (curRow == 1 || curRow == numRows) {
                goDown = !goDown;
            }

            curRow += goDown ? 1 : -1;
        }

        StringBuilder ans = new StringBuilder();
        for (StringBuilder row : rows) {
            ans.append(row.toString());
        }

        return ans.toString();
    }
}
