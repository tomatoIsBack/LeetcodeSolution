class Solution {
    public boolean isPalindrome(int x) {
        if (x == 0) {
            return true;
        }
        if (x < 0 || x % 10 == 0) {
            return false;
        }
        int x_reverse = 0;
        int rest = 0;
        while(x_reverse < x) {
            rest = x % 10;
            x /= 10;
            x_reverse = x_reverse * 10 + rest;
        }
        if (x_reverse == x || x_reverse/10 == x) {
            return true;
        }
        return false;
    }
}