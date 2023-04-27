def solution(myString):
    answer = ''
    for s in myString:
        if s == 'a':
            s = s.upper()
        elif s != 'A':
            s = s.lower()
        answer += s
    return answer