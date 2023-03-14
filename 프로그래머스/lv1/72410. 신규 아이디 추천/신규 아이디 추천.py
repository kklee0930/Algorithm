import re # 정규표현식 사용
def solution(new_id):
    # [^ = not이라는 뜻, a-z = a부터 z, \d = digit(숫자), ^ = 시작
    answer = re.sub('[^a-z\d\_\-\.]', '', new_id.lower())
    # + = 연속된다는 뜻
    answer = re.sub('\.\.+', '.', answer)
    # ^\. = 시작이 .
    answer = re.sub('^\.', '', answer)
    
    if answer == '':
        answer = 'a'
    
    # \.$ = 끝이 .
    answer = re.sub('\.$', '', answer[:15])
    
    # ljust(정렬할 길이, 공백이 생기면 채울 문자)
    if len(answer) <= 2:
        answer = answer.ljust(3, answer[-1])
    
    return answer
