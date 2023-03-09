def solution(k, m, score):
    temp = []
    answer = 0
    score.sort(reverse=True) # 편의를 위한 내림차순 정렬
    
    for num in score:
        temp.append(num)
        if len(temp) == m: # 상자에 사과가 가득찬 것만
            answer += min(temp) * m
            temp = [] # 상자 다시 비워주기
            
    return answer

        