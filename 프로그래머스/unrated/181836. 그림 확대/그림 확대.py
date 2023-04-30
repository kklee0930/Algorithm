def solution(picture, k):
    answer = []
    for p in picture: # ['.xx...xx.']
        for _ in range(k): # row k배 (세로로 k배 늘리기)
            temp = ''
            for i in range(len(p)):
                for _ in range(k):
                    temp += p[i]
            answer.append(temp)
    
    return answer