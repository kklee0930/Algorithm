def solution(n):
    # 에라토스테네스의 체
    answer = [1 for _ in range(n+1)] # n 크기 만큼의 리스트 생성(0 제외하기 때문에 n+1)
    for i in range(2, n+1): # 2부터 소수인지 판별
        if answer[i] == 0: # 체로 인해 이미 판별됐다면 다음 숫자로 넘어가기
            continue
        for j in range(2*i, n+1, i): # i의 배수 모두 지워주기
            answer[j] = 0
    answer = answer[2:].count(1) # 소수갯수 세기
    return answer