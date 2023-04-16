def solution(wallpaper):
    answer = []
    r = len(wallpaper) # 행
    c = len(wallpaper[0]) # 열
    
    min_r = r
    min_c = c
    max_r = 0
    max_c = 0
    
    for i in range(r):
        for j in range(c):
            if wallpaper[i][j] == '#':
                # 기존 값과 현재 좌표를 비교
                min_r = min(i, min_r)
                min_c = min(j, min_c)
                max_r = max(i, max_r)
                max_c = max(j, max_c)
            
    return [min_r, min_c, max_r+1, max_c+1]