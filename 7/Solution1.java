class Solution {
    public int reverse(int x) {
        int y = 0;
        while (x >= 10 || x <= -10) {
            y = y * 10 + x % 10;
            x /= 10;
        }
        if (Integer.MIN_VALUE / 10 <= y && y <= Integer.MAX_VALUE / 10) {
            return y * 10 + x;
        }
        return 0;
    }
}