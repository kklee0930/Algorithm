def solution(triangle):
    answer = 0
    dp = [[0 for j in i] for i in triangle] # triangle리스트 크기와 동일한 dp리스트 생성
    dp[0][0] = triangle[0][0] # bottom up 방식 적용
    
    for i in range(len(triangle)): # 0, 1, 2, 3, 4
        for j in range(i): # i=1 j=(0), 2 (0,1), 3 (0,1,2), 4 (0,1,2,3) (i=0은 제외)
            # dp[i-1][j+1]을 통해 정의한 값과 새로 정의한 값을 비교 (max(dp[i-1][j+1], dp[i-1][j] + triangle[i][j]))
            dp[i][j] = max(dp[i][j], dp[i-1][j] + triangle[i][j])
            dp[i][j+1] = dp[i-1][j] + triangle[i][j+1]
    return max(dp[-1])