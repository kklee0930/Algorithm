def check_blocks(m, n, board):
    equal = set()
    for i in range(m-1):
        for j in range(n-1):
            curr = board[i][j]
            if curr == '0':
                continue
            elif (curr == board[i+1][j] == board[i][j+1] == board[i+1][j+1]):
                equal.add((i,j))
                equal.add((i+1,j))
                equal.add((i,j+1))
                equal.add((i+1, j+1))
    return equal

def transpose(board):
    return list(zip(*board))

def shift(board):
    board = transpose(board)
    for i,x in enumerate(board):
        n = x.count('0')
        board[i] = n*'0' + ''.join(x).replace('0', '') # 빈칸의 갯수만큼 0을 배치하기 + 0은 삭제처리
    return transpose(board) # 다시 transpose
        
def solution(m, n, board):
    answer = 0
    while True:
        if not check_blocks(m,n,board):
            return answer
        else:
            answer += len(check_blocks(m,n,board))
            board = list(map(list, board)) # 인덱스 접근을 위한 보드 리스트화
            for i,j in check_blocks(m,n,board):
                board[i][j] = '0' # 같은 블록 삭제 과정
            # 빈칸 채우는 과정
            board = shift(board)