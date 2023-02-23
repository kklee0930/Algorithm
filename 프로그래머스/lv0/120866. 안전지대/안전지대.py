import copy
def solution(board):
    # 기존의 mine_map = board의 경우 얕은 복사로 인한 서로간의 영향으로 답이 틀렸음. 깊은 복사 적용
    mine_map = copy.deepcopy(board)
    # 안전지역 갯수 구하기 (세로 * 가로)
    answer = len(board) * len(board[0])
    # 세로 iteration
    for row in range(len(board)):
        # 가로 iteration
        for col in range(len(board[0])):
            if board[row][col] == 1:
                
                # range(인접지역), 인접지역이 범위를 벗어나지 않으면 1로 변환
                for row_shift in range(-1, 2):
                    row_changed = row + row_shift
                    
                    if 0 <= row_changed < len(board):
                        
                        for col_shift in range(-1, 2):
                            col_changed = col + col_shift
                            
                            if 0 <= col_changed < len(board[0]):
                                mine_map[row_changed][col_changed] = 1

    for r in mine_map:
        answer -= r.count(1)
        
    return answer
                    