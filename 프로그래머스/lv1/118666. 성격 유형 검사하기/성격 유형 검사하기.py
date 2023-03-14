def solution(survey, choices):
    answer = ''
    dict_ = {'R': 0, 'T': 0, 'C': 0, 'F': 0, 'J': 0, 'M': 0, 'A': 0, 'N': 0}
    
    for i in range(len(survey)):
        if choices[i] in range(1, 4): # 점수가 1~3
            dict_[survey[i][0]] += abs(choices[i] - 4) # 해당 알파벳에 1~3점 더하기
        elif choices[i] in range(5, 8): # 점수가 5~7
            dict_[survey[i][1]] += (choices[i] - 4) # 해당 알파벳에 1~3점 더하기
            
    result = []
    for i in ['RT', 'CF', 'JM', 'AN']:
        max_val = [[i[0], dict_[i[0]]], [i[1], dict_[i[1]]]] # [['알파벳', 해시[알파벳] 값], ['알파벳', 해시]]
        max_val.sort(key = lambda x: (-x[1], x[0])) # 큰 값을 기준으로 정렬, 점수가 같다면 사전순 정렬
        result.append(max_val)
    
    for score in result:
        answer += score[0][0]
    return answer
        