# Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
#
# Your algorithm's runtime complexity must be in the order of O(log n).
#
# If the target is not found in the array, return [-1, -1].
#
# 昇順にソートされた整数の配列があるとして、その中から特定の値の最初と最後の位置を配列として返すプログラムを作成してください
#
# 計算量はO(log n)である必要があります
#
# 対象が見つからない場合の結果は[-1, -1]としてください
#
# Example 1:
#
# Input: nums = [5,7,7,8,8,10], target = 8
# Output: [3,4]
# Example 2:
#
# Input: nums = [5,7,7,8,8,10], target = 6
# Output: [-1,-1]

class Test:

    def get_index(self, nums, target):

        if size(nums) == 0:
            return [-1, -1]

        result = binary_search(nums, target, 0, len(nums))


    def binary_search(nums, target, startIdx, endIdx):
        mid_idx = (startIdx + endIdx)/2

        if startIdx == endIdx:
            return [-1 , -1]

        if nums[mid_idx] == target:
            left_idx = binary_search(nums, target, startIdx, mid_idx)
            right_idx = binary_search(nums, target, mid_idx + 1, endIdx)
            if left_idx == -1:
                left_idx = mid_idx
            if right_idx == -1:
                right_idx = mid_idx
            return [left_idx, right_idx]

            elif ( nums[mid_idx] < target):
        return binary_search(nums, target, startIdx, mid_idx)
    else:
    return binary_search(nums, target, mid_idx + 1, endIdx)

if __name__ == '__main__':
    pass
      