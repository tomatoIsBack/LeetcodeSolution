class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) {
            return s;
        }
        int t = (numRows - 1) * 2;
        char[][] array = new char[numRows][(s.length() + t - 1) / t * (numRows - 1)];
        for (int i = 0, x = 0, y = 0; i < s.length(); i++) {
            array[x][y] = s.charAt(i);
            if (i % (2 * numRows - 2) < numRows - 1) {
                x++;
            } else{
                x--;
                y++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array[0].length; j++) {
                if(array[i][j] != 0 ) {
                    sb.append(array[i][j]);
                }
            }
        }
        return sb.toString();
    }
}