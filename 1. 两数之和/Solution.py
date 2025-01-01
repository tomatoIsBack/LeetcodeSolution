from typing import List


class Solution:

    #Solution 1
    def twoSum1(self, nums: List[int], target: int) -> List[int]:
        for i in range(len(nums)):
            for j in range(i+1, len(nums)):
                if (nums[i] + nums[j] == target):
                    return [i, j]
        return []

    #Solution 2
    def twoSum2(self, nums: List[int], target: int) -> List[int]:
        hashMap = dict()
        for i in range(len(nums)):
            if target - nums[i] in hashMap:
                return [hashMap[target - nums[i]], i]
            else:
                hashMap[nums[i]] = i
        return []