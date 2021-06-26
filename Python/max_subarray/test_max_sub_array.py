from max_subarray import get_max_subarray_sum

def test_get_max_sub_array():
    assert get_max_subarray_sum([1]), 1 
    assert get_max_subarray_sum([-2,1,-3,4,-1,2,1,-5,4]), 6
    assert get_max_subarray_sum([5,4,-1,7,8]), 23