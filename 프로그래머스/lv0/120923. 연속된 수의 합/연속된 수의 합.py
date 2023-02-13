def solution(num, total):
    med = total // num
    answer = []
    if total % num != 0 :
        for i in range(med - (num // 2 - 1), med + (num // 2 + 1)):
            answer.append(i)
    elif total % num == 0:
        for i in range(med - num // 2, med + num // 2 + 1):
            answer.append(i)
    answer.sort()
            
    return answer