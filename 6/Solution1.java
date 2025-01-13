class Solution {
    public String convert(String s, int numRows) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        if (numRows == 1) {
            return s;
        }
        while(i < numRows) {
            int right_right = (numRows - 1) * 2;
            int right_left = (numRows - 1 - i) * 2;
            int j = i;
            while(j < s.length()){
                result.append(s.charAt(j));
                if (j + right_left < s.length() && right_left != right_right && right_left != 0){
                    result.append(s.charAt(j + right_left));
                }
                j = j + right_right;
            }
            i++;
        }
        return result.toString();
    }
}