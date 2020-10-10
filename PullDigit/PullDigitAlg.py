def removeTarget(nums, val):
    start = 0
    end = len(nums) - 1
    mid = 0
    while mid <= end:
        if nums[mid] != val:
            nums[start], nums[mid] = nums[mid], nums[start]
            start += 1
            mid += 1
        else:
            mid += 1
    return start