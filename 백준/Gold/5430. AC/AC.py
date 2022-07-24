from collections import deque

T = int(input())
for tc in range(1, T+1):
    cmd = str(input()) # 수행할 함수
    n = int(input()) # 배열에 들어있는 수의 갯수
    arr = deque(input()[1:-1].split(','))
    
    R_count = 0
    
    if n == 0:
        arr = []
        
    for i in cmd:
        if i == 'R':
            R_count += 1
        elif i == 'D':
            if len(arr) == 0:
                print('error')
                break
            else:
                if R_count % 2 == 0:
                    arr.popleft()
                else:
                    arr.pop()
    else:
        if R_count % 2 == 0:
            print('[' + ','.join(arr) + ']')
        else:
            arr.reverse()
            print('[' + ','.join(arr) + ']')