def solution(n):
    answer = []
    array = []
    
    if n == 1:
        return [1]
    
    for i in range(1, n+1):
        array.append([0]*i)

    cnt = 0
    i = 0
    j = 0

    while True:
        while i < len(array) and not array[i][j]: # i+=1 이동
            cnt += 1
            array[i][j] = cnt
            i += 1
        i -= 1 # 좌표 원위치
        if array[i][j+1]: # 다음 이동 좌표가 0이 아니면 과정 종료.
            break
        j += 1
            
        while j < len(array[-1]) and not array[i][j]: # j+=1 이동
            cnt += 1
            array[i][j] = cnt
            j += 1
        j -= 1 # 좌표 원위치
        if array[i-1][j-1]: # 다음 이동 좌표가 0이 아니면 과정 종료.
            break
        i -= 1
        j -= 1
            
        while not array[i][j]: # i-=1, j-=1 이동
            cnt += 1
            array[i][j] = cnt
            i -= 1
            j -= 1
        i += 1 # 좌표 원위치
        j += 1 # 좌표 원위치
        if array[i+1][j]: # 다음 이동 좌표가 0이 아니면 과정 종료.
            break
        i += 1
        
    for li in array:
        answer.extend(li)
    return answer