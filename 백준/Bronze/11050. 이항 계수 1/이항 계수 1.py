N,K = map(int, input().split())
numerator = 1
denominator = 1
for num in range(N, 0, -1):
    numerator *= num
    
for num in range(K, 0 , -1):
    denominator *= num
for num in range(N-K, 0, -1):
    denominator *= num

print(numerator//denominator)