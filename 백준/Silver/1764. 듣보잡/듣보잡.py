# N:듣도 못한 사람 
# M:보도 못한사람
N, M = map(int, input().split()) 
dict = {}
result = []

for _ in range(N):
    dict[input()] = 1
    
for _ in range(M):
    seen = input()
    if dict.get(seen) == 1:
        result.append(seen)
    
result.sort()
print(len(result))
print('\n'.join(result))