def solution(m, n, puddles):
    maps = [[0]*(m+1) for _ in range(n+1)] # 인덱스 0 시작하는 것 고려해서 m+1, n+1
    for i, j in puddles: # 웅덩이는 전부 1로 표기
        maps[j][i] = 1
    maps[1][0] = 1 # 또는 maps[0][1] = 1로 해도 무관
    for i in range(1, n+1):
        for j in range(1, m+1):
            if maps[i][j]: # 웅덩이일 경우에는 지나갈 수 있는 길이 없으므로 0처리
                maps[i][j] = 0
            else: # 현재 좌표 값 += 이전에 지나왔던 길에서의 가짓 수 % 1000000007
                maps[i][j] = (maps[i-1][j] + maps[i][j-1]) % 1000000007
    return maps[n][m]
