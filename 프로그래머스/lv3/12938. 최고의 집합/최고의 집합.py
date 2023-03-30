def solution(n, s):
    if s / n < 1: # 최고의 집합 존재하지 않음
        return [-1]
    
    answer = []
    
    for cnt in range(n, 0, -1): # 2, 1
        q = s // cnt # s값을 cnt로 나눈 몫 q가 최댓값이 된다.
        answer.append(q)
        s -= q # s값을 계속 갱신해준다
        
    return sorted(answer)