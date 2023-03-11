def solution(X, Y):
    result = []
    answer = ''
    x_dict = {}
    y_dict = {}
    
    # X, Y 문자열의 각 숫자갯수를 dictionary에 추가
    for x in X:
        if x not in x_dict:
            x_dict[x] = 1
        else:
            x_dict[x] += 1
    
    for y in Y:
        if y not in y_dict:
            y_dict[y] = 1
        else:
            y_dict[y] += 1
    
    # dictionary의 길이가 더 작은 것을 기준으로 iteration
    if len(x_dict) <= len(y_dict):
        for x_key, x_value in x_dict.items(): # {x_key: x_value} {'숫자': 나온횟수}
            if x_key in y_dict.keys(): # x와 y문자열에 공통적으로 존재했던 숫자면
                result.append([x_key, min(x_value, y_dict[x_key])]) # 공통으로 나타나는 숫자와 횟수를 짝지어 append
                
    elif len(y_dict) < len(x_dict):
        for y_key, y_value in y_dict.items():
            if y_key in x_dict.keys():
                result.append([y_key, min(y_value, x_dict[y_key])])
    
    # 가장 큰 수를 만들어야 함으로 result 리스트의 숫자가 들어있는 result[x][0]를 기준으로 내림차순 정렬
    result.sort(key=lambda x: x[0], reverse=True)
    
    for i in range(len(result)):
        answer += result[i][0] * result[i][1] # 숫자 * 횟수를 answer에 추가
    if answer == '':
        return '-1'
    elif list(set(answer)) == ['0']:
        return '0'
    return answer