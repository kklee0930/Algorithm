dict = {}
n_A, n_B = map(int, input().split())

A = map(int, input().split())
B = map(int, input().split())

for i in A:
    if i not in dict:
        dict[i] = 1
    else:
        dict[i] += 1
        
for j in B:
    if j in dict:
        dict[j] += 1
        
result = []

for k,v in dict.items():
    if v == 1:
        result.append(k)
result.sort()

print(len(result))
print(*result)