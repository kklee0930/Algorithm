def solution(myString):
    answer = ''
    for c in myString:
        if ord(c) < 108:
            answer += 'l'
        else:
            answer += c
    return answer