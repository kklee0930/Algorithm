def solution(n):
    answer = 1 # 자기 자신으로 표현하는 경우 1가지

    for num1 in range(1, n+1):
        result = num1 # ex: 1
        for num2 in range(num1+1, n+1): # ex: 2, 3, 4...
            result += num2
            if result == n: # 표현 가능하면 +1
                answer += 1
                break
            elif result > n: # 표현 불가능하면 다음 수로 넘어가기
                break
    return answer