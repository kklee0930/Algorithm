def solution(sizes):
    answer = 0
    w = 0
    h = 0
    
    for i in range(len(sizes)):
        if sizes[i][1] > sizes[i][0]: # 세로 길이가 가로보다 길면 카드를 돌려준다
            sizes[i] = [sizes[i][1], sizes[i][0]] # 더 긴 원소가 0자리에 오게함
            
        # 가장 긴 가로, 세로 크기 찾기
        if sizes[i][0] > w:
            w = sizes[i][0]
        if sizes[i][1] > h:
            h = sizes[i][1]
            
    answer = w * h
    return answer