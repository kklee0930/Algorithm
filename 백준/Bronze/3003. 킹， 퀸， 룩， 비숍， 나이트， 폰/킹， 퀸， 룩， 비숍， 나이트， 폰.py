corr_chess = [1,1,2,2,2,8]
n = list(map(int, input().split()))

result = []

for i in range(len(n)):
    result.append(corr_chess[i] - n[i])
    
print(*result)