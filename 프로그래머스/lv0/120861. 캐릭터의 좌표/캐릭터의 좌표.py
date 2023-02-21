def solution(keyinput, board):
    answer = [0, 0]
    limit = [board[0] // 2, board[1] // 2]
    for command in keyinput:
        if command == 'left':
            if answer[0] > -limit[0]:
                answer[0] -= 1
                
        if command == 'right':
            if answer[0] < limit[0]:
                answer[0] += 1
                
        if command == 'up':
            if answer[1] < limit[1]:
                answer[1] += 1
                
        if command == 'down':
            if answer[1] > -limit[1]:
                answer[1] -= 1
            
    return answer