def solution(arr):
    answer = 0
    arr2 = []
    
    while arr != arr2:
        arr2 = list(arr)
        for i in range(len(arr)):
            if arr[i] < 50 and arr[i] % 2 != 0:
                arr[i] = int(arr[i] * 2 + 1)
            elif arr[i] >= 50 and arr[i] % 2 == 0:
                arr[i] = int(arr[i] / 2)

        if arr == arr2:
            return answer
        else:
            answer += 1
            
    return answer