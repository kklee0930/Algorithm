hashmap = {}

n = int(input()) # 10
N = input().split() # 6 3 2 10 10...

m = int(input()) # 8 
M = input().split() # 10 9 -5 2 3 4 5 ...

for num in N:
    if num in hashmap:
        hashmap[num] += 1
    else:
        hashmap[num] = 1
        
for num in M:
    if num in hashmap:
        print(hashmap[num], end=' ')
    else:
        print(0, end= ' ')