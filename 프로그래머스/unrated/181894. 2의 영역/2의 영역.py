def solution(arr):
    answer = []
    a = 0
    b = 0
    
    for i in range(len(arr)):
        if arr[i] == 2:
            a = i
            break
    for j in range(len(arr)-1, -1, -1):
        if arr[j] == 2:
            b = j
            break
            
    if a == 0 and b == 0:
        return [-1]
    else:
        return arr[a:b+1]