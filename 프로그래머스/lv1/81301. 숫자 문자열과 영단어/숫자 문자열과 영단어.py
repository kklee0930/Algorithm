def solution(s):
    answer = ''
    dict_ = {
        'one': '1',
        'two': '2',
        'three': '3',
        'four': '4',
        'five': '5',
        'six': '6',
        'seven': '7',
        'eight': '8',
        'nine': '9',
        'zero': '0'
    }
    str_ = ''
    
    for num in s:
        try: # 숫자일 경우
            int(num)
            answer += num
        except: # 숫자가 아닌 문자일 경우
            str_ += num
        if str_ in dict_.keys(): # 합친 문자열이 dictionary에 존재할경우
            answer += dict_[str_] # value를 answer에 추가
            str_ = ''
            
    answer = int(answer)
    return answer