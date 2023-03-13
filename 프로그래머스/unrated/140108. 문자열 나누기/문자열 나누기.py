def solution(s):
    result = []
    answer = 0
    x_cnt = 0 # x 갯수
    non_x_cnt = 0 # x 아닌 것 갯수
    str_ = '' # 분해문자열
    
    for i in range(len(s)):
        if str_ == '': # 분해를 시작할 때
            start_pnt = i # 분해 시작 지점
            x = s[i] # x값
            x_cnt += 1 # x갯수
            str_ += s[i]
            continue # 분해 시작할 때는 뒤의 절차가 필요 없으므로 continue
            
        if s[i] == x: # x이면
            x_cnt += 1
            
        else: # x가 아니면
            non_x_cnt += 1
        
        str_ += s[i]
        
        if x_cnt == non_x_cnt: # 갯수가 같으면
            result.append(str_) # 분해 문자열을 리스트에 추가
            str_ = '' # 분해 문자열 초기화
            x_cnt, non_x_cnt = 0, 0 # 갯수 초기화
    
    if str_ != '': # 분해되지 않은 잔여 문자열이 존재할경우 리스트에 추가
        result.append(str_)
            
    answer = len(result)
    return answer
            