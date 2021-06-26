def get_max_subarray_sum(nums):
    max_sum=0
    local_sum=0
    for i in nums:
        max_sum=max(max_sum, local_sum+i)
        local_sum=max(0,local_sum+i)
    return max_sum