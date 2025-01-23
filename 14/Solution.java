class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        for(int i = 0; i < strs.length; i++) {
            int j = 0;
            if (strs[i].length() < length) {
                length = strs[i].length();
            }
            while(j < length) {
                if(strs[i].charAt(j) == strs[0].charAt(j)) {
                    j++;
                } else {
                    length = j;
                    break;
                }
            }
        }
        return strs[0].substring(0, length);
    }
}