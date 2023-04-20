def solution(record):
    answer = []
    dict_ = {'Enter': '님이 들어왔습니다.', 'Leave': '님이 나갔습니다.'}
    cmd = []
    
    for rec in record:
        data = rec.split()
        if data[0] != 'Change': # 닉네임 변경이 아닐 경우
            cmd.append([data[0], data[1]]) # [Enter/Leave, uid____]
            if data[0] == 'Enter':
                dict_[data[1]] = data[2] # uid와 닉네임 매칭
        else:
            dict_[data[1]] = data[2] # uid와 닉네임 매칭
            
    for i in cmd:
        answer.append(dict_[i[1]]+dict_[i[0]])
    
    return answer