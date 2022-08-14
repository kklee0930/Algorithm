temp_lst = []

max_height = 1
max_length = 0

N = int(input())
for i in range(N):
    L,H = map(int,input().split())
    temp_lst.append([L,H])

    if max_length < L:
        max_length = L
    
    if max_height < H:
        max_height = H
        max_idx = L

cnt = [0] * (max_length + 1)

for L,H in temp_lst:
    cnt[L] = H
    
total = 0
temp = 0

for i in range(max_idx+1):
    if cnt[i] > temp:
        temp = cnt[i]
    total += temp

temp = 0

for j in range(max_length,max_idx,-1):
    if cnt[j] > temp:
        temp = cnt[j]
    total += temp

print(total)