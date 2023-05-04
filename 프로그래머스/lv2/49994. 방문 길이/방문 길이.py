def solution(dirs):
    answer = 0
    c = [0,0] # 현재 좌표
    li = [] # 지났던 좌표인지 기록을 위한 리스트
    for cmd in dirs:
        if cmd == 'U':
            if c[1] + 1 not in range(-5, 6): # 구간을 벗어나면 무시
                continue
            # 지나지 않았던 구간일 경우
            if [c[0],c[1],c[0],c[1]+1] not in li and [c[0],c[1]+1,c[0],c[1]] not in li:
                li.append([c[0],c[1],c[0],c[1]+1]) # 이동 전과 이동 후 지점 기록
                answer += 1 # 길이 + 1
            c[1] += 1 # 현재 좌표 변경
                
        elif cmd == 'L':
            if c[0] - 1 not in range(-5, 6):
                continue
            if [c[0],c[1],c[0]-1,c[1]] not in li and [c[0]-1,c[1],c[0],c[1]] not in li:
                li.append([c[0],c[1],c[0]-1,c[1]])
                answer += 1
            c[0] -= 1
            
        elif cmd == 'D':
            if c[1] - 1 not in range(-5, 6):
                continue
            if [c[0],c[1],c[0],c[1]-1] not in li and [c[0],c[1]-1,c[0],c[1]] not in li:
                li.append([c[0],c[1],c[0],c[1]-1])
                answer += 1
            c[1] -= 1
            
        elif cmd == 'R':
            if c[0] + 1 not in range(-5, 6):
                continue
            if [c[0],c[1],c[0]+1,c[1]] not in li and [c[0]+1,c[1],c[0],c[1]] not in li:
                li.append([c[0],c[1],c[0]+1,c[1]])
                answer += 1
            c[0] += 1
        
    return answer