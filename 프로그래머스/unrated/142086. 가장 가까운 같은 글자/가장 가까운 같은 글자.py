def solution(s):
    answer = []
    for i in range(len(s)): # 문자열 s iteration
        for j in range(i-1, -1, -1): # 문자 i 기준 앞의 글자들 iteration
            if s[i] == s[j]: # 같으면 거리차 값 answer에 추가
                answer.append(i-j) 
                break
        if len(answer) != i+1: # iteration에서 추가된 거리값 없으면 같은 글자가 존재하지 않는다는 뜻이므로
            answer.append(-1) # -1 추가
            
    return answer