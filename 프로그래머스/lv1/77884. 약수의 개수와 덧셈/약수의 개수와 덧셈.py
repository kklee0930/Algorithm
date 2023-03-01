def solution(left, right):
    answer = 0
    for num in range(left, right+1):
        temp = []
        for i in range(1, num+1): # 약수구하기
            if num % i == 0:
                temp.append(i)
        if len(temp) % 2 == 0: # 약수 갯수가 짝수면 +, 홀수면 -
            answer += num
        else:
            answer -= num
            
    return answer