def solution(s, n):
    answer = ''
    
    # ord(z): 122 / ord(Z): 90
    # ord(a): 97 / ord(A): 65
    for elem in s:
        if elem != ' ':
            num = ord(elem)+n # 유니코드로 변환 + n만큼 시프트
            if ord(elem) in range(97, 123): # 소문자
                if num > 122: # z를 벗어나면
                    answer += chr((num - 123) + 97) # 벗어난만큼 a에서 +
                else:
                    answer += chr(num)
                    
            elif ord(elem) in range(65, 91): # 대문자
                if num > 90: # Z를 벗어나면
                    answer += chr((num - 91) + 65) # 벗어난만큼 A에서 +
                else:
                    answer += chr(num)
                
        else: # 공백일 경우 아무리 밀어도 공백
            answer += elem
    return answer