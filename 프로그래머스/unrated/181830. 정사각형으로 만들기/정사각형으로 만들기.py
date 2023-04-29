def solution(arr):
    r_cnt = len(arr)
    c_cnt = len(arr[0])
    
    if r_cnt > c_cnt:
        for i in arr:
            i.extend([0]*(r_cnt-c_cnt))
    elif r_cnt < c_cnt:
        for _ in range(c_cnt-r_cnt):
            arr.append([0]*c_cnt)
    return arr