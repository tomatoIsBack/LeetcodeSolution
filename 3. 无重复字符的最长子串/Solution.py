class Solution:

    #Solution 1 
    #暴力
    def lengthOfLongestSubstring1(self, s: str) -> int:
        result = 0
        for i in range(len(s)):
            count = 0
            hashSet = set()
            for j in range(i, len(s)):
                if s[j] not in hashSet:
                    count += 1
                    hashSet.add(s[j])
                else:
                    break
            result = max(count, result)
        return result

    #Solution 2
    #滑动子串
    def lengthOfLongestSubstring2(self, s: str) -> int:
        left = 0
        right = 0
        result = 0
        hashSet = set()
        while right < len(s):
            if s[right] not in hashSet:
                hashSet.add(s[right])
                right += 1
                result = max(result, right - left)
            else:
                hashSet.remove(s[left])
                left += 1

        return result