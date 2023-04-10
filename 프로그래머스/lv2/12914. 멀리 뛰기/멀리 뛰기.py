def solution(n):
    if n <= 2:
        return n % 1234567
    # dp 사용
    dp = [0] * (n+1) # 인덱스 0부터 시작하는 것 감안하여 [0] * (n+1)
    dp[1], dp[2] = 1, 2 # 1칸을 움직이는 방법은 1가지, 2칸을 움직이는 방법은 (1,1), (2,0) 두가지.
    for i in range(3, n+1):
        dp[i] = dp[i-1] + dp[i-2]
    return dp[n] % 1234567
