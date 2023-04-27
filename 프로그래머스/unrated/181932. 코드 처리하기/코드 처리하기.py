def solution(code):
    answer = ''
    mode = 0
    for i in range(len(code)):
        if mode == 0:
            if code[i] == '1':
                mode = 1
            elif i % 2 == 0:
                answer += code[i]
        elif mode == 1:
            if code[i] == '1':
                mode = 0
            elif i % 2 != 0:
                answer += code[i]
                
    if answer == '':
        return 'EMPTY'
    return answer