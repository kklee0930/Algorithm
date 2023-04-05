def solution(keymap, targets):
    answer = []
    dic = {}
    
    for k in keymap:
        for i in range(len(k)):
            if k[i] not in dic: # 해시에 존재하지 않으면 i+1을 값으로 추가(1부터 시작하는 것 감안하여)
                dic[k[i]] = i+1
            elif i+1 < dic[k[i]]: # 인덱스 값이 기존 해시 값보다 작으면 재정의
                dic[k[i]] = i+1
                
    for t in targets:
        cnt = 0
        for char in t:
            if char not in dic: # 문자열이 해시에 존재하지 않으면 -1
                answer.append(-1)
                break
            else:
                cnt += dic[char]
        else:
            answer.append(cnt)
    return answer