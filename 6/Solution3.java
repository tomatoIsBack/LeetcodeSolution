class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int r = 2 * numRows - 2;
        StringBuilder[] sbs = new StringBuilder[numRows];
        for(int i = 0; i < sbs.length; i++) {
            sbs[i] = new StringBuilder();
        }
        for(int i = 0, x = 0; i < s.length(); i++) {
            sbs[x].append(s.charAt(i));
            if(i % r < numRows - 1) {
                x++;
            } else {
                x--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < sbs.length; i++) {
            sb.append(sbs[i]);
        }
        return sb.toString();
    }
}