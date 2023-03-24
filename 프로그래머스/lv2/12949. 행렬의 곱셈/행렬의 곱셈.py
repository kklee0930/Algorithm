def solution(arr1, arr2): 
    a = len(arr1)
    b = len(arr2[0])
    
    arr = [[0 for col in range(b)] for row in range(a)]
    
    for i, val1 in enumerate(arr1): # i: 0, val: [1, 4]
        for k, val2 in enumerate(val1): # k: 0, val: 1
            for j in range(b): 
                arr[i][j] += arr1[i][k] * arr2[k][j]
    return arr