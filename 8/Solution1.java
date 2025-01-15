class Solution {
    public int myAtoi(String s) {
        int i = 0;
        boolean sign = true;
        long result = 0;
        while(i < s.length()) {
            if(s.charAt(i) == ' ') {
                i++;
            } else {
                break;
            }
        }
        if (i < s.length()){
            if(s.charAt(i) == '-') {
                sign = false;
                i++;
            } else if(s.charAt(i) == '+') {
                i++;
            }
        }
        while(i < s.length()) {
            if(Character.isDigit(s.charAt(i))) {
                if(sign) {
                    result = result * 10 + Character.getNumericValue(s.charAt(i));
                    if(result > Integer.MAX_VALUE) {
                        return Integer.MAX_VALUE;
                    }
                } else {
                    result = result * 10 - Character.getNumericValue(s.charAt(i));
                    if(result < Integer.MIN_VALUE) {
                        return Integer.MIN_VALUE;
                    }
                }
            } else {
                break;
            }
            i++;
        }
        return (int) result;
    }
}