import sys

input = sys.stdin.readline

X = input().strip() # 처음 문자열
Y = input().strip() # 2번째 문자열

x_length = len(X)
y_length = len(Y)

LCS = [[0] * (y_length+1) for _ in range(x_length+1)] # 최장 공통 부분 수열

for i in range(1, x_length+1):
    for j in range(1, y_length+1):
        
        if X[i-1] == Y[j-1]: # 이전 문자열이 같으면 +1
            LCS[i][j] = LCS[i-1][j-1] + 1
        else: # 아니면 더 큰 LCS 값으로 갱신
            LCS[i][j] = max(LCS[i-1][j], LCS[i][j-1])
            
print(LCS[x_length][y_length])