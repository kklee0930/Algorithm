def solution(participant, completion):
    answer = ''
    dict_ = {}
    
    for name in participant: # 참가자 명단 dictionary에 기록
        if name not in dict_: # 명단에 없으면 추가
            dict_[name] = 1
        else: # 동명이인
            dict_[name] += 1 
            
    for completed in completion: # 완주자 iteration
        if completed not in dict_: # 이름이 dictionary에 없으면 완주 실패
            return completed
        else:
            dict_[completed] -= 1 # 완주자 있으면 -1
    
    for key, value in dict_.items(): # 동명이인 중 한명 완주 실패 시
        if value > 0:
            return key