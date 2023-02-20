def solution(n):
    answer = []
    divider = 2 # 소인수분해의 분해는 2부터 시작
    while divider < n: 
        if n % divider == 0: # 나누어 떨어질 경우
            answer.append(divider) # 소인수를 append
            n = n // divider # n 갱신
            divider = 2 # 다시 절차 진행
        else:
            divider += 1
    answer.append(n)
    answer = sorted(list(set(answer)))
    return answer