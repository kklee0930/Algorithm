def solution(s):
    answer = 0
    
    for i in range(len(s)): # 총 s의 크기만큼 회전
        str_ = list(s)
        for j in range(i): # 회전과정
            char = str_[0]
            str_.remove(char)
            str_.append(char)
        
        stack = []
        for elem in str_: # 올바른 괄호 문자열인지 체크
            stack.append(elem)
            if len(stack) >= 2:
                if ''.join(stack[-2:]) in ['()', '[]', '{}']: # 마지막 두 문자열이 쌍이면 제거
                    stack = stack[:-2]
                    
        if stack == []: # 스택이 비면 올바른 괄호 문자열.
            answer += 1

    return answer