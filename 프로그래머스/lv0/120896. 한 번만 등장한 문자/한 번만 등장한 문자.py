def solution(s):
    answer = []
    for i in s:
        if s.count(i) == 1:
            answer.append(i)
        s.strip(i)
    if len(answer) == 0:
        return ''
    else:
        answer.sort()
        answer = ''.join(answer)
        return answer