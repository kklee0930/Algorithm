total = int(input())
result = 0
for _ in range(int(input())):
    cost, N = map(int,input().split())
    result += cost * N
if result == total:
    print('Yes')
else:
    print('No')