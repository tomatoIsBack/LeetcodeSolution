class Solution {

    //Solution 1
    //暴力
    public int lengthOfLongestSubstring1(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            Set<Character> set = new HashSet<>();
            int max = 0;
            for (int j = i; j < s.length(); j++) {
                if (set.contains(s.charAt(j))) {
                    break;
                } else {
                    set.add(s.charAt(j));
                    max += 1;
                }
            }
            result = Math.max(result, max);
        }
        return result;
    }

    //Solution 2
    public int lengthOfLongestSubstring2(String s) {
        int result = 0;
        int left = 0;
        int right = 0;
        Set<Character> set = new HashSet<>();
        while (right < s.length()) {
            if (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            } else {
                set.add(s.charAt(right));
                right++;
                result = Math.max(result, right - left);
            }
        }
        return result;
    }

}
