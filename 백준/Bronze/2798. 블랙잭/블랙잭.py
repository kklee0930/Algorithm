N,M = map(int, input().split())
cards = list(map(int,input().split()))

sum_ = 0
for i in range(N):
    for j in range(i+1, N):
        for k in range(j+1, N):
            if cards[i]+cards[j]+cards[k] > M:
                pass
            else:
                sum_ = max(sum_, cards[i]+cards[j]+cards[k])
print(sum_)