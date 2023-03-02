def solution(arr):
    answer = []
    
    for num in arr:
        if answer == []:
            answer.append(num)
        elif answer[-1] != num:
            answer.append(num)
            
    return answer