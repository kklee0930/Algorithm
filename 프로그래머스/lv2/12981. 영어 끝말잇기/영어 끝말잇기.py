def solution(n, words):
    answer = [0,0]
    dict_ = {}
    last_c = ''
    
    for i in range(len(words)):
        # 마지막 문자와 첫 문자가 이어지는지 확인
        if last_c == '':
            last_c = words[i][-1]
        elif last_c != words[i][0]:
            a = (i % n) + 1 # 차례
            b = (i // n) + 1 # 번호
            return [a,b]
        else:
            last_c = words[i][-1]
        
        # 한번 나왔던 문자인지 확인
        if words[i] not in dict_:
            dict_[words[i]] = 1
        else:
            a = (i % n) + 1 # 차례
            b = (i // n) + 1 # 번호
            return [a,b]

    return answer