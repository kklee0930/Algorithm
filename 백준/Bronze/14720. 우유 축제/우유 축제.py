from sys import stdin

n = int(stdin.readline())

milk_store = list(map(int, stdin.readline().split()))

# 딸,초,바 (0,1,2)
count = 0

for i in range(n):
    # 한번 사이클이 3이기 때문에 count(현재까지 마신 우유 수) % 3
    if count % 3 == milk_store[i]:
        count += 1
        
print(count)