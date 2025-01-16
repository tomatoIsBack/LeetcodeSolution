class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        int cur = 0;
        while(left < right) {
            cur = Math.min(height[left], height[right]) * (right - left);
            if(cur > max) {
                max = cur;
            }
            if(height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}