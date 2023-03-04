def solution(n, arr1, arr2):
    # 십진법 -> 이진법으로 변환 과정 요구
    # n = 지도의 변의 길이
    # 이진수로 변환했을 때, if 10001 이면 '#   #'
    list1 = []
    list2 = []
    answer = []
    
    for num in arr1: # 9(10) -> 9 % 2 == 1, 4 % 2 == 0, 2 % 2 == 0, 
        temp1 = []
        while True:
            remain = num % 2
            num  = num // 2
            temp1.append(remain)
            if num == 0:
                break
        
        while len(temp1) < n:
            temp1.append(0)
        temp1 = temp1[::-1]
        list1.append(temp1)
    
    for num in arr2: # 9(10) -> 9 % 2 == 1, 4 % 2 == 0, 2 % 2 == 0, 
        temp2 = []
        while True:
            remain = num % 2
            num  = num // 2
            temp2.append(remain)
            if num == 0:
                break
        
        while len(temp2) < n:
            temp2.append(0)
        temp2 = temp2[::-1]
        list2.append(temp2)
        
    for i in range(n):
        str_ = ''
        for j in range(n):
            if list1[i][j] == 1 or list2[i][j] == 1:
                str_ += '#'
            elif list1[i][j] == 0 and list2[i][j] == 0:
                str_ += ' '
        answer.append(str_)
                
        
    return answer