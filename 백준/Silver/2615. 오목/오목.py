import sys
input = sys.stdin.readline
board = [] # 바둑판

for _ in range(19): # 가로 19 만큼 반복
    board.append(list(map(int,input().split()))) # 세로 19개(input)을 리스트로 board리스트에 반영

# 델타탐색 위한 좌표 하, 우, 우상, 우하
dx = [0,1,-1,1]
dy = [1,0,1,1]

for i in range(19): # 바둑판 가로의 길이만큼 반복
    for j in range(19): # 바둑판 세로의 길이만큼 반복
        # 검은 돌 혹은 흰 돌이 나오면 델타탐색 시작
        if board[i][j] != 0:
            
            for d in range(4): # 델타탐색 범위 크기만큼 반복
                stone_count = 1 # 검/흰돌 1개
                
                # 델타 탐색 (다음 좌표 탐색)
                nx = i + dx[d]
                ny = j + dy[d]
                
                # 범위 제한 충족하고 이전 좌표값과 델타탐색 좌표값이 같을 때만
                while 0 <= nx < 19 and 0 <= ny < 19 and board[i][j] == board[nx][ny]:
                    stone_count += 1
                    
                    # 육목인지 체크
                    if stone_count == 5:
                        # 첫 점에서 한번 더 델타 탐색 했을 때 같은지 확인
                        if 0 <= i - dx[d] < 19 and 0 <= j - dy[d] < 19 and board[i - dx[d]][j - dy[d]] == board[i][j]:
                            break
                        # 마지막 점에서 한번 더 델타 탐색 했을 때 같은지 확인
                        if 0 <= nx + dx[d] < 19 and 0 <= ny + dy[d] < 19 and board[nx + dx[d]][ny + dy[d]] == board[i][j]:
                            break
                        print(board[i][j]) # 이긴 돌 색깔 출력
                        print(i + 1, j + 1)
                        sys.exit(0)

                    nx += dx[d]
                    ny += dy[d]
print(0)