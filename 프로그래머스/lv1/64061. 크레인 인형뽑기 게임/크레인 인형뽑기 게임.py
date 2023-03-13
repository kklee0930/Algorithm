def solution(board, moves):
    answer = 0
    bucket = []
    for cmd in moves: # 크레인이 움직이는 위치 리스트 
        for i in range(len(board)): # board iteration
            if board[i][cmd-1] != 0: # board[0~len(board)][집게 위치] (인형이 존재하면)
                bucket.append(board[i][cmd-1]) # 인형을 바구니에 추가
                board[i][cmd-1] = 0 # 인형 삭제 처리

                if len(bucket) >= 2 and bucket[-1] == bucket[-2]: # 바구니 인형갯수 최소 2개, 상단2개가 같은 인형
                    answer += 2 # 같은 인형 터트려서 사라짐
                    bucket.pop()
                    bucket.pop()
                break
            
    return answer