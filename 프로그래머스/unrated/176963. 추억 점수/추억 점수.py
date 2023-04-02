def solution(name, yearning, photo):
    answer = []
    dict_ = {}
    
    for i in range(len(name)):
        dict_[name[i]] = yearning[i] # 그리움점수 해시에 저장
        
    for i in photo: # 이차원 배열
        res = 0 # 총 그리움 점수
        for j in i: # 사람이름
            if j in dict_:
                res += dict_[j]
        answer.append(res)
    return answer