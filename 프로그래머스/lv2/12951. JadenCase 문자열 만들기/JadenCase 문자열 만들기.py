def solution(s):
    # first case capital, else: lower, if first != alphabet : following lower
    result = []
    list_ = s.split(' ')
    
    for str_ in list_:
        try: # 알파벳으로 시작할 경우
            if len(str_) == 1:
                str_ = str_.upper()
            elif len(str_) > 1:
                str_ = str_[0].upper() + str_[1:].lower()
                
        except: # 알파벳으로 시작하지 않을 경우
            str_ = str_[0] + str_[1:].lower()
            
        result.append(str_)
        
    answer = ' '.join(result)
    return answer